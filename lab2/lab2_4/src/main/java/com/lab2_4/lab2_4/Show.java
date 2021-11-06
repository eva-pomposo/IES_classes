package com.lab2_4.lab2_4;

public class Show {
	private final long id;
    private final String name;
    private final String slug;
    
    public Show(long id, String name, String slug) {
        this.name = name;
        this.slug = slug;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public String getSlug() {
        return slug;
    }
    
    public long getId() {
        return id;
    }
    
}
