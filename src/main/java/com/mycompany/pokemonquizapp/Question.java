package com.mycompany.pokemonquizapp;

import java.util.Random;

public class Question {
    private Pokemon pokemon;
    private String question;
    private Boolean correctAnswer;
    private Boolean userAnswer;
    
    //random Move questions about a specific pokemon
    //some of this can be put into separate methods for re-use
    public Question(Pokemon pokemon) {  
        this.pokemon = pokemon; 
        pokemon.removeMovesBelowLevel(5); 
        
        if (pokemon.getMoves().isEmpty()) {
            //TODO error - request new pokemon
            System.out.println("Moves is empty!");
        }
        
        //choose random move
        int maxMoves = pokemon.getMoves().size();
        Random random = new Random();
        int randomMoveNo = random.nextInt(maxMoves - 1);
        PokemonMove move = pokemon.getMoves().get(randomMoveNo);
        
        //choose random version
        int maxVersions = move.getVersionGroupDetails().size();
        int randomVersionNo = 0;
        if (maxVersions > 1) {
            randomVersionNo = random.nextInt(maxVersions - 1);
        }        
        MoveVersionGroupDetails versionDetails = move.getVersionGroupDetails().get(randomVersionNo);
        
        //get the necessary details
        String pokemonName = pokemon.getName();
        String moveName = move.getMoveInfo().getName();
        int levelLearnedAt = versionDetails.getLevelLearnedAt();
        String versionName = versionDetails.getVersionGroup().getName();
        
        this.correctAnswer = true;
        if (random.nextInt(10) >= 5) {
            this.correctAnswer = false;
            levelLearnedAt = random.nextInt(101); //because max level is 100
            //System.out.println("Level learned changed and answer changed to false:");
        }

        this.question = pokemonName + " learns " + moveName + 
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
