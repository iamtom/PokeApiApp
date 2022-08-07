package com.mycompany.pokeapiapp;

public class Species {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.url;
    }
    
    
}
