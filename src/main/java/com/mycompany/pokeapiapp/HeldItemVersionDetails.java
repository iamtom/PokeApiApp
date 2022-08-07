package com.mycompany.pokeapiapp;

public class HeldItemVersionDetails {
    private String rarity;
    private VersionSimple version;

    public String getRarity() {
        return rarity;
    }

    public VersionSimple getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "HeldItemVersionDetails{" + "rarity=" + rarity + ", version=" + version + '}';
    }
    
    
}
