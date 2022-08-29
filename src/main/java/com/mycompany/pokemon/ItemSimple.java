package com.mycompany.pokemonquizapp;

public class ItemSimple {
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
        return "ItemSimple{" + "name=" + name + ", url=" + url + '}';
    }
    
}
