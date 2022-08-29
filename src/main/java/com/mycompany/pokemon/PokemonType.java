package com.mycompany.pokemon;

public class PokemonType {
   private int slot;
   private TypeSimple type;

    public int getSlot() {
        return slot;
    }

    public TypeSimple getType() {
        return type;
    }

    @Override
    public String toString() {
        return "PokemonType{" + "slot=" + slot + ", type=" + type + '}';
    }
   
   
}
