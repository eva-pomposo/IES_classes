package com.lab3_3.lab3_3.services;

import java.util.List;
import java.util.Random;

import com.lab3_3.lab3_3.entities.Movie;
import com.lab3_3.lab3_3.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> saveMovies(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public String deleteMovie(int id) {
        movieRepository.deleteById(id);
        return "movie removed !! " + id;
    }

    public Movie updateMovie(Movie movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).orElse(null);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setYear(movie.getYear());
        return movieRepository.save(existingMovie);
    }

    public Movie randMovie() {
        Random random = new Random(); 
        List<Movie> movies = movieRepository.findAll();

        if (movies.size() > 0) {
            return movies.get(random.nextInt(movies.size()));
        }

        return null;
    }

}
