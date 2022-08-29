package com.mycompany.pokemon;

public class PokemonForm {
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
        return "PokemonForm{" + "name=" + name + ", url=" + url + '}';
    }
    
    
}
