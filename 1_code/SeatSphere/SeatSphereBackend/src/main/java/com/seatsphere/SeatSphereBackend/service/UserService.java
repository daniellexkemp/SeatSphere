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
}