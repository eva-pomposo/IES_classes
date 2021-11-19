package com.lab3_3.lab3_3.services;

import java.util.List;
import java.util.Random;

import com.lab3_3.lab3_3.entities.Movie;
import com.lab3_3.lab3_3.entities.Quote;
import com.lab3_3.lab3_3.repositories.QuoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public Quote saveQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public List<Quote> saveQuotes(List<Quote> quotes) {
        return quoteRepository.saveAll(quotes);
    }

    public List<Quote> getQuotes() {
        return quoteRepository.findAll();
    }

    public Quote getQuoteById(int id) {
        return quoteRepository.findById(id).orElse(null);
    }

    public String deleteQuote(int id) {
        quoteRepository.deleteById(id);
        return "quote removed !! " + id;
    }

    public Quote updateQuote(Quote quote) {
        Quote existingQuote = quoteRepository.findById(quote.getId()).orElse(null);
        existingQuote.setQuote(quote.getQuote());
        return quoteRepository.save(existingQuote);
    }

    public Quote randQuote(Movie movie) {
        Random random = new Random(); 
        List<Quote> quotes = quoteRepository.findByMovie(movie);

        if (quotes.size() > 0) {
            return quotes.get(random.nextInt(quotes.size()));
        }

        return null;
    }

}
