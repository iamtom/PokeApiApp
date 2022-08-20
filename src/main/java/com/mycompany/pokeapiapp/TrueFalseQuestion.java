package com.mycompany.pokeapiapp;

import java.util.ArrayList;
import java.util.Random;

public class TrueFalseQuestion {
    private Pokemon pokemon;
    private String question;
    private Boolean answer;
    
    public TrueFalseQuestion() {
        //Just move level questions for now
        //pick a pokemon, does it have moves, pick the version group, if level learned <5 then retry
        Request request = new Request();
        
        Pokemon randomPokemon = request.randomPokemon();
        
        //if the Pokemon has no moves request a new one
        while (randomPokemon.getMoves().isEmpty()) {
            randomPokemon = request.randomPokemon();
        }
        
        this.pokemon = randomPokemon;
        ArrayList<PokemonMove> moves = this.pokemon.getMoves();
                
        //Pick a random move
        Random random = new Random();
        
        //choose the move
        int randomMoveNo = random.nextInt(moves.size() - 1);                
        PokemonMove move = moves.get(randomMoveNo);
        
        while (move.getVersionGroupDetails().isEmpty()) {
            //if the version group arraylist is empty we need a new move
            randomMoveNo = random.nextInt(moves.size() - 1);                
            move = moves.get(randomMoveNo);
        }        
        
        //Get the move name
        String moveName = move.getMove().getName();
        
        //Pick a random version group      
        int versionGroupArraySize = move.getVersionGroupDetails().size();
        int randomVersionGroupNo = 0;
        if (versionGroupArraySize > 1) {
            /*if there is more than one version group then we can choose it at random
            otherwise it can stay as is*/
            randomVersionGroupNo = random.nextInt(versionGroupArraySize - 1);
        }

        MoveVersionGroupDetails version = move.getVersionGroupDetails().get(randomVersionGroupNo);
        String versionName = version.getVersionGroup().getName();
        int levelLearnedAt = version.getLevelLearnedAt();
        
        //TODO decide if true or false with random number
        //if false decide a random level for levelLearnedAt
        //TODO if level learned at is 0 then re-try
        
        this.question = this.pokemon.getName() + " learns " + moveName + 
                " at level " + levelLearnedAt + " in " + versionName + 
                " version(s). True or false?";
    }

    public String getQuestion() {
        return question;
    }
    
    
    

}
