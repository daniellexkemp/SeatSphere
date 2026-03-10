package com.seatsphere.SeatSphereBackend.service;

import com.seatsphere.SeatSphereBackend.model.Movie;
import com.seatsphere.SeatSphereBackend.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> searchMovies(String keyword) {
        return movieRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(updatedMovie.getTitle());
                    movie.setGenre(updatedMovie.getGenre());
                    movie.setDuration(updatedMovie.getDuration());
                    movie.setRating(updatedMovie.getRating()); 
                    movie.setPrice(updatedMovie.getPrice());   
                    return movieRepository.save(movie);
                })
                .orElseGet(() -> {
                    updatedMovie.setId(id);
                    return movieRepository.save(updatedMovie);
                });
    }
}
