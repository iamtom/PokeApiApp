package com.mycompany.pokemonquizapp;

import com.mycompany.pokemon.MoveVersionGroupDetails;
import com.mycompany.pokemon.PokemonMove;
import com.mycompany.pokemon.Pokemon;
import java.util.Random;

public class Question {
    private String questionText;
    private PokemonMove move;
    private MoveVersionGroupDetails versionDetails;
    private Boolean correctAnswer;
    private Boolean userAnswer;
    private Random random;
    
    //random Move questions about a specific pokemon
    //some of this can be put into separate methods for re-use
    public Question(Pokemon pokemon) throws Exception { 
        this.random = new Random();
        
        pokemon.removeMovesBelowLevel(5); 
        
        if (pokemon.getMoves().isEmpty()) {
            throw new Exception("Error: Pokemon has no moves!");            
        }
        
        move = pokemon.randomMove();

        versionDetails = move.randomMoveVersionGroupDetails();
        
        //get the necessary details
        String pokemonName = pokemon.getName();
        pokemonName = StringFormatter.basicFormat(pokemonName);
        String moveName = move.getMoveInfo().getName();
        moveName = StringFormatter.basicFormat(moveName);
        int levelLearnedAt = versionDetails.getLevelLearnedAt();
        String versionName = versionDetails.getVersionGroup().getName();
        
        String versionEnd;        
        switch(versionName) {
            case "colosseum":
                versionEnd = ".";
                break;
            case "xd":
                versionEnd = ".";
                //versionName = "XD";
                break;
            default:
                versionEnd = " version(s).";
        }       
        
        versionName = StringFormatter.formatVersionName(versionName);
        
        this.correctAnswer = true;
        if (random.nextInt(10) >= 5) {            
            levelLearnedAt = random.nextInt(101); //because max level is 100
            this.correctAnswer = false;
            //System.out.println("Level learned changed and answer changed to false:");
        }
        
        //this.setQuestion(pokemonName, moveName, levelLearnedAt, versionName, versionEnd);
        this.questionText = pokemonName + " learns " + moveName + 
                " at level " + levelLearnedAt + " in " + versionName + 
                versionEnd + " True or false?"; 
    }
    
    public String getQuestionText() {
        return questionText;
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

    public void setCorrectAnswer(Boolean answer) {
        this.correctAnswer = answer;
    }

}
