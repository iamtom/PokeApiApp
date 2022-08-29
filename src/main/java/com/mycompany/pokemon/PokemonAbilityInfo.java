package com.mycompany.pokemonquizapp;

import com.google.gson.annotations.SerializedName;

public class PokemonAbilityInfo {
    private AbilitySimple ability;
    @SerializedName("is_hidden")
    private Boolean isHidden;
    private Double slot;

    public AbilitySimple getAbilitySimple() {
        return ability;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public Double getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return "AbilityInfo{" + "ability=" + ability + ", is_hidden=" + isHidden + ", slot=" + slot + '}';
    }
    
    
    
}
