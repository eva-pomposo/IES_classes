package com.lab2_4.lab2_4;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Filme {
    private int id;
    private String name;
    private String slug;
    private boolean contain_adult_lang;
    private String role;
    private List<String> quotes = new ArrayList<>();
    
    public Filme(int id, String name, String slug, boolean contain_adult_lang, String role) {
        this.name = name;
        this.slug = slug;
        this.contain_adult_lang = contain_adult_lang;
        this.role = role;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public boolean isContain_adult_lang() {
        return contain_adult_lang;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public void addQuote(String quote){
        quotes.add(quote);
    }

    public String getRandomQuote(){
        Random r = new Random();
        int low = 0;
        int high = quotes.size() - 1;
        int index = r.nextInt(high-low+1) + low;
        return quotes.get(index);
    }

}
