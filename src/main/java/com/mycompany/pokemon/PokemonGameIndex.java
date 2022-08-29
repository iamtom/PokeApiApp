package com.mycompany.pokemon;

import com.google.gson.annotations.SerializedName;

public class PokemonGameIndex {
    @SerializedName("game_index")
    private String gameIndex;
    private VersionSimple version;

    public String getGameIndex() {
        return gameIndex;
    }

    public VersionSimple getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "GameIndex{" + "gameIndex=" + gameIndex + ", version=" + version + '}';
    }
    
}
