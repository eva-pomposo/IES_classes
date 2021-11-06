package com.lab2_4.lab2_4;

public class Quote {
	private final long id;
    private final String quote;
    private final String role;
    private final String show;
    private final boolean contain_adult_lang;

    public Quote(long id, String quote, String role, String show, boolean contain_adult_lang) {
        this.id = id;
        this.quote = quote;
        this.role = role;
        this.show = show;
        this.contain_adult_lang = contain_adult_lang;
    }

    public long getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public String getRole() {
        return role;
    }

    public String getShow() {
        return show;
    }

    public boolean isContain_adult_lang() {
        return contain_adult_lang;
    }
}
