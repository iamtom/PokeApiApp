package com.mycompany.pokeapiapp;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class PokemonHeldItem {
    private ItemSimple item;
    @SerializedName("version_details")
    private ArrayList<HeldItemVersionDetails> versionDetails;

    public ItemSimple getItem() {
        return item;
    }

    public ArrayList<HeldItemVersionDetails> getVersionDetails() {
        return versionDetails;
    }

    @Override
    public String toString() {
        return "PokemonHeldItem{" + "item=" + item + ", versionDetails=" + versionDetails + '}';
    }
    
    
}
