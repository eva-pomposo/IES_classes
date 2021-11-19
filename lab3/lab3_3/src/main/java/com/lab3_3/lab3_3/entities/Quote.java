package com.lab3_2.lab3_2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String quote;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public Quote() {
    }

    public Quote(String quote, Movie movie) {
        this.quote = quote;
        this.movie = movie;
    }

    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "quote", nullable = false)
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Column(name = "id", nullable = false)
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Quote [id=" + id + ", movie=" + movie + ", quote=" + quote + "]";
    }

}
