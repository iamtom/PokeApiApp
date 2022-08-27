package com.mycompany.pokemonquizapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    public int score;
    public int noOfQuestions; 
    public ArrayList<Question> questions;
    
    public Quiz(int noOfQuestions) {
        this.questions = new ArrayList<>();
        this.noOfQuestions = noOfQuestions;
                
        for (int i = 0; i < noOfQuestions; i++) {
            Question question = new Question();
            this.questions.add(question);
            System.out.println(question.getQuestion());        
        }        
    }
    
    public Quiz(String pokemonName, int noOfQuestions) {
        this.questions = new ArrayList<>();
        this.noOfQuestions = noOfQuestions;
        Request request = new Request();               
        Pokemon pokemon = request.searchPokemon(pokemonName); 
        
        int i = 0;        
        while (i < noOfQuestions) {
            try {
                Question question = new Question(pokemon);
                this.questions.add(question);
                i++;
                System.out.println(question.getQuestion());
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
            i++;
        }             
    }
    
    public void runQuiz() {
        Scanner scanner = new Scanner(System.in);
        
        //ask each question and record the answers
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i+1));
            System.out.println(currentQuestion.getQuestion());
            String userInput = scanner.nextLine();
            
            //convert user input to Boolean and save the answer
            if (userInput.equalsIgnoreCase("true") || userInput.equalsIgnoreCase("false")) {
                Boolean userAnswer = Boolean.valueOf(userInput);
                currentQuestion.setUserAnswer(userAnswer);
            } else {
                System.out.println("Answer not valid.");
            }
            
            
        }
        
        System.out.println("Now checking your answers...");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        
        this.score = checkAnswers(questions);
        
        System.out.println("Score: " + this.score + "/" + this.noOfQuestions);
    }
    
    public int checkAnswers(ArrayList<Question> questions) {
        int score = 0;
        
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            
            Boolean result = currentQuestion.checkAnswer();
            
            if (result.equals(true)) {
                score++;
            }
            
        }
        
        return score;
    }
    
    
    
}
