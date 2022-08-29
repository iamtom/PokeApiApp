package com.mycompany.pokemonquizapp;

import java.util.Scanner;

public class PokemonQuizApp {

    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("Pokemon Move Quiz!");
            System.out.println("Menu:");
            System.out.println("1. Specific Pokemon");
            System.out.println("2. Random Pokemon");
            int userInput;

            System.out.println("Type the number of the option you want and press enter");
            userInput = Integer.valueOf(scanner.nextLine());

            switch (userInput) {
                case 1:
                    try {
                        specificQuiz();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Something went wrong. Please check spelling.");                      
                    }
                    break;
                case 2:
                    randomQuiz();
                    break;
                default:
                    System.out.println("Selection not recognised");
                    break;
            }
            
            System.out.println("Play again? Y/N");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("Y")) {
                break;
            }        
        }
    }
    
    public static void specificQuiz() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Which Pokemon would you like to be quized on?");
        System.out.println("Enter a name and press enter:");
        String pokemonName = scanner.nextLine();
        System.out.println("How many questions would you like to answer?");
        System.out.println("Enter a number and press enter:");
        int noOfQuestions = Integer.valueOf(scanner.nextLine());
        
        Quiz quiz = new Quiz(pokemonName, noOfQuestions);
        quiz.runQuiz();                
    }
    
    public static void randomQuiz() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many questions would you like to answer?");
        System.out.println("Enter a number and press enter:");
        int noOfQuestions = Integer.valueOf(scanner.nextLine());

        Quiz quiz = new Quiz(noOfQuestions);
        quiz.runQuiz();
    }
}
