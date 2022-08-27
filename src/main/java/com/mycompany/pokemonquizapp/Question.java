package com.mycompany.pokemonquizapp;

import java.util.ArrayList;
import java.util.Random;

public class Question {
    private Pokemon pokemon;
    private String question;
    private Boolean correctAnswer;
    private Boolean userAnswer;
    
    //random Move questions about a specific pokemon
    public Question(Pokemon pokemon) {        
        //has it got moves?
        
        pokemon.removeMovesBelowLevel(5);                        
        //choose a random move
    }
    
    //random Pokemon and random Move question
    public Question() {
        //Just move level questions for now
        //pick a pokemon, does it have moves, pick the version group, if level learned <5 then retry
        //This whole constructor needs cleaning up and improving
        Request request = new Request();
        Random random = new Random();
        
        Pokemon randomPokemon = new Pokemon();
        ArrayList<PokemonMove> moves = new ArrayList<PokemonMove>();
        PokemonMove move = new PokemonMove();
        MoveVersionGroupDetails version;
        String versionName = "version";
        int levelLearnedAt = 0;
        String moveName = "move";

        
        //should probably incorporate some of the below into a hasMoves method of Pokemon
        while (true) {
            randomPokemon = request.randomPokemon();
//            move = findRandomMove(randomPokemon, 5);
//            if (move == null) {
//                //if the pokemon has no moves then try again
//                continue;
//            }
            if (randomPokemon.getMoves().isEmpty()) {
                //if the Pokemon has no moves start again
                continue;
            }
            
            this.pokemon = randomPokemon;
            moves = this.pokemon.getMoves();
            
            int randomMoveNo = 0;

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

            
            
            if (levelLearnedAt < 5) {
                continue;
            }
            
            this.correctAnswer = true;
            //decide whether to keep as true or change levelLearnedAt and make the answer false
            if (random.nextInt(11) >= 5) {
                this.correctAnswer = false;
                levelLearnedAt = random.nextInt(101); //because max level is 100
                System.out.println("Level learned changed and answer changed to false:");
            }
            
            moveName = move.getMove().getName();
            
            break;
            
        }
        
        this.question = this.pokemon.getName() + " learns " + moveName + 
                " at level " + levelLearnedAt + " in " + versionName + 
                " version(s). True or false?";
    }

    public String getQuestion() {
        return question;
    }
    
    public Boolean checkAnswer() {
        Boolean checkResult = null;
        
        if (this.userAnswer.equals(this.correctAnswer)) {
            checkResult = true;
        }
        if (!this.userAnswer.equals(this.correctAnswer)) {
            checkResult = false;
        }      
        
        return checkResult;
    }

    public void setUserAnswer(Boolean userAnswer) {
        this.userAnswer = userAnswer;
    }
}
