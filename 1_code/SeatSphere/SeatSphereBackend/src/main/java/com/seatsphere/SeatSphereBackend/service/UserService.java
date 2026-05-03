package com.seatsphere.SeatSphereBackend.service;

import com.seatsphere.SeatSphereBackend.model.User;
import com.seatsphere.SeatSphereBackend.repository.UserRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder; // Inject the BCrypt engine

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User login(String username, String rawPassword) {
            User user = userRepository.findByUsername(username);
            
            // This is the "magic" that compares your Postman password 
            // to the scrambled hash in the database
            if (user != null && passwordEncoder.matches(rawPassword, user.getPassword())) {
                return user; 
            }
            return null; // Login failed
        }


    // Hashes the password before saving to MySQL
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Hashes the new password if the user is being updated
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    // Hash the new password during update
                    user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                    user.setRole(updatedUser.getRole());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    updatedUser.setId(id);
                    updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                    return userRepository.save(updatedUser);
                });
    }

    public void initializeSystemUsers() {
        // Data for the 4 specific  ---- CHANGE THESE TO YOUR LIKING ----
        // REMEMBER TO curl -X POST http://localhost:####/api/users/init-setup INSIDE THE COMMAND PROMPT TO SEND THESE TO THE BACKEND DATABASE
        String[][] staffData = {
            {"First_Name", "Last_Name", "manager_FirstName", "FirstName@seatsphere.com", "MANAGER"},
            {"First_Name", "Last_Name", "admin_system", "root@seatsphere.com", "ADMIN"},
            {"First_Name", "Last_Name", "staff_FirstName", "FirstName@seatsphere.com", "STAFF"},
            {"First_Name", "Last_Name", "customer_FirstName", "FirstName@gmail.com", "CUSTOMER"}
        };

        for (String[] data : staffData) {
            // Find existing user to avoid duplicate errors
            User existing = userRepository.findByUsername(data[2]);
            if (existing != null) {
                userRepository.delete(existing);
            }

            // Create a new User object
            User newUser = new User();
            newUser.setFirstName(data[0]);
            newUser.setLastName(data[1]);
            newUser.setUsername(data[2]);
            newUser.setEmail(data[3]);
            newUser.setRole(data[4]);
            
            // Use your existing plain-text password requirement
            // This will be hashed by the createUser method
            // You can change "password123" to whatever default password you want for these users
            newUser.setPassword("password123"); 
            
            // Pass it through your existing createUser method to handle hashing
            this.createUser(newUser);
        }
    }
}
