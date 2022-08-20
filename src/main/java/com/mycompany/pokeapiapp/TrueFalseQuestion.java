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
        Random random = new Random();
        
        Pokemon randomPokemon = request.randomPokemon();
        ArrayList<PokemonMove> moves = randomPokemon.getMoves();
        PokemonMove move = moves.get(0);
        MoveVersionGroupDetails version;
        String versionName = "version";
        int levelLearnedAt = 0;
        String moveName = "move";

        
        //should probably incorporate some of the below into a hasMoves method of Pokemon
        while (true) {
            randomPokemon = request.randomPokemon();
            if (randomPokemon.getMoves().isEmpty()) {
                //if the Pokemon has no moves start again
                continue;
            }
            
            this.pokemon = randomPokemon;
            moves = this.pokemon.getMoves();
            
            int randomMoveNo = 0;
            
            if (moves.isEmpty()) {
                //if Pokemon has no moves restart the loop and try again
                continue;
            }
            if (moves.size() > 1) {
                //if there is more than one move we choose a random one
                randomMoveNo = random.nextInt(moves.size() - 1);                
                move = moves.get(randomMoveNo);
            }
                                 
            while (move.getVersionGroupDetails().isEmpty()) {
                //if the version group arraylist is empty we need a new move
                randomMoveNo = random.nextInt(moves.size() - 1);                
                move = moves.get(randomMoveNo);
            }  
            
            //Pick a random version group      
            int versionGroupArraySize = move.getVersionGroupDetails().size();
            int randomVersionGroupNo = 0;
            if (versionGroupArraySize > 1) {
                /*if there is more than one version group then we can choose it at random
                otherwise it can stay as is*/
                randomVersionGroupNo = random.nextInt(versionGroupArraySize - 1);
            }
            
            version = move.getVersionGroupDetails().get(randomVersionGroupNo);
            versionName = version.getVersionGroup().getName();
            levelLearnedAt = version.getLevelLearnedAt();
            
            //need a Pokemon method that returns moves learned over a certain level?
            //or one that returns a random move?
            if (levelLearnedAt < 5) {
                continue;
            }
            
            moveName = move.getMove().getName();
            
            break;
            
        }

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
