package com.mycompany.pokemonquizapp;

import com.mycompany.pokemon.Pokemon;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private int score;
    private int noOfQuestions; 
    private ArrayList<Question> questions;
    
    //random move quiz on multiple random pokemon   
    public Quiz(int noOfQuestions) {
        this.questions = new ArrayList<>();
        this.noOfQuestions = noOfQuestions;
        Request request = new Request();
        int questionsMade = 0;
        
        while (questionsMade < noOfQuestions) {
            Pokemon pokemon = request.randomPokemon();
            Question question;
            
            try {
                question = new Question(pokemon);
            } catch (Exception e) {
                //a problem will occur if the pokemon has no moves so start again
                System.out.println(e.getMessage());
                continue;
            }
            
            this.questions.add(question);
            //System.out.println(question.getQuestion());              
            questionsMade++;
        }      
    }
    
    //random move quiz on a specific pokemon
    public Quiz(String pokemonName, int noOfQuestions) {
        this.questions = new ArrayList<>();
        this.noOfQuestions = noOfQuestions;
        Request request = new Request();
        Pokemon pokemon = request.searchPokemon(pokemonName); 
 
        for (int i = 0; i < noOfQuestions; i++) {
            try {
                Question question = new Question(pokemon);
                this.questions.add(question);
                //System.out.println(question.getQuestion());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }             
    }
    
    public void runQuiz() {
        Scanner scanner = new Scanner(System.in);
        int questionNo = 0;
        
        //ask each question and record the answers
        while (questionNo < questions.size()) {
            Question currentQuestion = questions.get(questionNo);
            System.out.println("Question " + (questionNo+1));
            System.out.println(currentQuestion.getQuestionText());
            String userInput = scanner.nextLine();
            
            //convert user input to Boolean and save the answer
            if (userInput.equalsIgnoreCase("true") || userInput.equalsIgnoreCase("false")) {
                Boolean userAnswer = Boolean.valueOf(userInput);
                currentQuestion.setUserAnswer(userAnswer);
            } else {
                System.out.println("Answer not valid.");
                continue;
            }
            
            questionNo++;
        }
        
        System.out.println("Now checking your answers...");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        
        this.score = checkAnswers(questions);
        
        System.out.println("Score: " + this.score + "/" + this.noOfQuestions);
    }
    
    public int checkAnswers(ArrayList<Question> questions) {
        this.score = 0;
        
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            
            Boolean result = currentQuestion.checkAnswer();
            
            if (result.equals(true)) {
                this.score++;
            }
            
        }
        
        return this.score;
    }  
}
