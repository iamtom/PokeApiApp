package com.mycompany.pokemon;

import com.google.gson.annotations.SerializedName;

public class PokemonStat {
    @SerializedName("base_stat")
    private int baseStat;
    private int effort;
    private StatSimple stat;

    public int getBaseStat() {
        return baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public StatSimple getStat() {
        return stat;
    }

    @Override
    public String toString() {
        return "PokemonStat{" + "baseStat=" + baseStat + ", effort=" + effort + ", stat=" + stat + '}';
    }
    
    
    
    
}
