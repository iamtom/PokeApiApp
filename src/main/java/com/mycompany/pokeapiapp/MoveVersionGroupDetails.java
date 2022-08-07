package com.mycompany.pokeapiapp;

import com.google.gson.annotations.SerializedName;

public class MoveVersionGroupDetails {
    @SerializedName("level_learned_at")
    private int levelLearnedAt;
    
    @SerializedName("move_learn_method")
    private MoveLearnMethod moveLearnMethod;
    
    @SerializedName("version_group")
    private VersionGroup versionGroup;

    public int getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    @Override
    public String toString() {
        return "MoveVersionGroupDetails{" + "levelLearnedAt=" + levelLearnedAt + ", moveLearnMethod=" + moveLearnMethod + ", versionGroup=" + versionGroup + '}';
    }       
}
