package com.mycompany.pokeapiapp;

import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Pokemon {   
    private ArrayList<PersonalAbilityInfo> abilities;   
    @SerializedName("base_experience") //TODO serialize names for other attributes where needed
    private Double baseExperience;
    private ArrayList forms;
    private ArrayList game_indices;
    private Double height;
    private ArrayList held_items;
    private String id;
    private Boolean is_default;
    private String location_area_encounters;
    private ArrayList moves;
    private String name;
    private Double order;
    private ArrayList past_types;
    private Species species;
    private Object sprites;
    private ArrayList stats;
    private ArrayList types;
    private Double weight;

    public ArrayList<PersonalAbilityInfo> getAbilities() {
        return abilities;
    }

    public Double getBaseExperience() {
        return baseExperience;
    }

    public ArrayList getForms() {
        return forms;
    }

    public ArrayList getGame_indices() {
        return game_indices;
    }

    public Double getHeight() {
        return height;
    }

    public ArrayList getHeld_items() {
        return held_items;
    }

    public String getId() {
        return id;
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
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

    public ArrayList getPast_types() {
        return past_types;
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
