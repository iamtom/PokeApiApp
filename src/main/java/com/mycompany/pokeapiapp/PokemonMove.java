package com.mycompany.pokeapiapp;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class PokemonMove {
    private MoveSimple move;
    
    @SerializedName("version_group_details")
    private ArrayList<MoveVersionGroupDetails> versionGroupDetails;

    public MoveSimple getMove() {
        return move;
    }

    public ArrayList<MoveVersionGroupDetails> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    @Override
    public String toString() {
        return "PokemonMove{" + "move=" + move + ", versionGroupDetails=" + versionGroupDetails + '}';
    }  
}