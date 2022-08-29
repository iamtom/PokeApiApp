package com.mycompany.pokemonquizapp;

import com.mycompany.pokemon.MoveVersionGroupDetails;
import com.mycompany.pokemon.PokemonMove;
import com.mycompany.pokemon.Pokemon;
import java.util.Random;

public class Question {
    private Pokemon pokemon;
    private String question;
    private Boolean correctAnswer;
    private Boolean userAnswer;
    
    //random Move questions about a specific pokemon
    //some of this can be put into separate methods for re-use
    public Question(Pokemon pokemon) throws Exception {  
        this.pokemon = pokemon; 
        pokemon.removeMovesBelowLevel(5); 
        
        if (pokemon.getMoves().isEmpty()) {
            throw new Exception("Pokemon has no moves!");            
        }
        
        //choose random move
        int maxMoves = pokemon.getMoves().size();
        Random random = new Random();
        int randomMoveNo = 0;
        if (maxMoves > 1) {
            randomMoveNo = random.nextInt(maxMoves - 1);
        }
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
        pokemonName = StringFormatter.format(pokemonName);
        String moveName = move.getMoveInfo().getName();
        moveName = StringFormatter.format(moveName);
        int levelLearnedAt = versionDetails.getLevelLearnedAt();
        String versionName = versionDetails.getVersionGroup().getName();
        versionName = StringFormatter.format(versionName);
        
        //formatting
        
        
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
