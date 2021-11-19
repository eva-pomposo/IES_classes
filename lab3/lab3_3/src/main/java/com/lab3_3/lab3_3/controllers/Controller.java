package com.lab3_3.lab3_3.controllers;

import com.lab3_3.lab3_3.entities.Movie;
import com.lab3_3.lab3_3.entities.Quote;
import com.lab3_3.lab3_3.services.MovieService;
import com.lab3_3.lab3_3.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private MovieService movieService;

    @Autowired
    private QuoteService quoteService;

    @PostMapping("/addQuote")
    public Quote addQuote(@RequestBody Quote quote) {
        return quoteService.saveQuote(quote);
    }

    @GetMapping("/quoteByMovie")
    public Quote getQuoteByMovie(@RequestParam(name="movie", required = true) int idMovie) {
        return quoteService.randQuote(movieService.getMovieById(idMovie));
    }

    @GetMapping("/quote")
    public Quote randQuote() {
        Movie movie = movieService.randMovie();

        if (movie == null) {
            return null;
        }

        Quote quote = quoteService.randQuote(movie);

        if (quote == null) {
            return null;
        }

        return quote;
    }

    @GetMapping("/movies")
    public List<Movie> movies() {
        return movieService.getMovies();
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }


}