package com.mycompany.pokemonquizapp;

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
       
    public void removeVersionsBelowMinLevel(int minLevel) {
        ArrayList<MoveVersionGroupDetails> tempList = new ArrayList<>();
        
        for (int i = 0; i < this.versionGroupDetails.size(); i++) {
            int levelLearnedAt = this.versionGroupDetails.get(i).getLevelLearnedAt();
            if (levelLearnedAt >= minLevel) {
                tempList.add(this.versionGroupDetails.get(i));
            }
        }
        this.versionGroupDetails = tempList;
    }
    
    @Override
    public String toString() {
        return "PokemonMove{" + "move=" + move + ", versionGroupDetails=" + versionGroupDetails + '}';
    }  
}