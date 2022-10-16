package com.mycompany.pokemon;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Random;

public class PokemonMove {
    @SerializedName("move")
    private MoveSimple moveInfo;
    
    @SerializedName("version_group_details")
    private ArrayList<MoveVersionGroupDetails> versionGroupDetails;
    
    private transient Random random;
    
    public PokemonMove() {
        this.random = new Random();
    }

    public MoveSimple getMoveInfo() {
        return moveInfo;
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
        this.versionGroupDetails = new ArrayList<>(tempList);
    }
    
    public MoveVersionGroupDetails randomMoveVersionGroupDetails() {
        int maxVersions = this.getVersionGroupDetails().size();
        int randomVersionNo = 0;
        if (maxVersions > 1) {
            randomVersionNo = this.random.nextInt(maxVersions - 1);
        }        
        MoveVersionGroupDetails versionDetails = this.getVersionGroupDetails().get(randomVersionNo);
        
        return versionDetails;
    }
    
    @Override
    public String toString() {
        return "PokemonMove{" + "move=" + moveInfo + ", versionGroupDetails=" + versionGroupDetails + '}';
    }  
}