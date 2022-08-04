package com.mycompany.pokeapiapp;

import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Pokemon {   
    private ArrayList<PokemonAbilityInfo> abilities; 
    
    @SerializedName("base_experience")
    private Double baseExperience;
    
    private ArrayList<PokemonForm> forms;
    
    @SerializedName("game_indices")
    private ArrayList<PokemonGameIndex> gameIndices;
    
    private Double height;
    
    @SerializedName("held_items")
    private ArrayList<PokemonHeldItem> heldItems; 
    
    private String id;
    
    @SerializedName("is_default")
    private Boolean isDefault;
    
    @SerializedName("location_area_encounters")
    private String locationAreaEncounters;
    
    private ArrayList moves; //TODO
    private String name;
    private Double order;
    
    @SerializedName("past_types")
    private ArrayList pastTypes; //TODO
    
    private Species species;
    private Object sprites;
    private ArrayList stats; //TODO
    private ArrayList types; //TODO
    private Double weight;

    public ArrayList<PokemonAbilityInfo> getAbilities() {
        return abilities;
    }

    public Double getBaseExperience() {
        return baseExperience;
    }

    public ArrayList<PokemonForm> getForms() {
        return forms;
    }

    public ArrayList<PokemonGameIndex> getGameIndices() {
        return gameIndices;
    }

    public Double getHeight() {
        return height;
    }

    public ArrayList getHeldItems() {
        return heldItems;
    }

    public String getId() {
        return id;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public ArrayList getMoves() {
        return moves;
    }

    public String getName() {
        return name;
    }

    public Double getOrder() {
        return order;
    }

    public ArrayList getPastTypes() {
        return pastTypes;
    }

    public Species getSpecies() {
        return species;
    }

    public Object getSprites() {
        return sprites;
    }

    public ArrayList getStats() {
        return stats;
    }

    public ArrayList getTypes() {
        return types;
    }

    public Double getWeight() {
        return weight;
    }


    
    
    
    
    
    
}
