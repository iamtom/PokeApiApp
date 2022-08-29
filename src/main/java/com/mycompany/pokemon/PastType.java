package com.mycompany.pokemon;

import java.util.ArrayList;

public class PastType {
    private Generation generation;
    private ArrayList<PokemonType> types;

    public Generation getGeneration() {
        return generation;
    }

    public ArrayList<PokemonType> getTypes() {
        return types;
    }

    @Override
    public String toString() {
        return "PastType{" + "generation=" + generation + ", types=" + types + '}';
    }
    
    
}
