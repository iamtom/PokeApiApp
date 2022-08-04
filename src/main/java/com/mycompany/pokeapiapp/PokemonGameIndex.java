/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokeapiapp;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Tom
 */
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
