package com.mycompany.pokemonquizapp;

import java.util.Scanner;

public class ConsoleUserInterface {
    private final Scanner scanner;
    
    public ConsoleUserInterface() {
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        while(true) {
            System.out.println("Pokemon Move Quiz!\n");
            System.out.println("Menu:");
            System.out.println("1. Specific Pokemon");
            System.out.println("2. Random Pokemon\n");
            int userInput;

            System.out.println("Type the number of the option you want and press enter");
            userInput = Integer.valueOf(scanner.nextLine());
            System.out.println("");

            switch (userInput) {
                case 1:
                    try {
                        specificQuiz();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Something went wrong. Please check spelling.\n");                      
                    }
                    break;
                case 2:
                    randomQuiz();
                    break;
                default:
                    System.out.println("Selection not recognised\n");
                    break;
            }
            
            System.out.println("Play again? Y/N");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("Y")) {
                break;
            }        
        }
    }
    
    public void specificQuiz() {       
        System.out.println("Which Pokemon would you like to be quized on?");
        System.out.println("Enter a name and press enter:");
        String pokemonName = this.scanner.nextLine();
        System.out.println("");
        System.out.println("How many questions would you like to answer?");
        System.out.println("Enter a number and press enter:");
        int noOfQuestions = Integer.valueOf(this.scanner.nextLine());
        System.out.println("");
        
        Quiz quiz = new Quiz(pokemonName, noOfQuestions);
        quiz.runQuiz();                
    }
    
    public void randomQuiz() {        
        System.out.println("How many questions would you like to answer?");
        System.out.println("Enter a number and press enter:");
        int noOfQuestions = Integer.valueOf(this.scanner.nextLine());
        System.out.println("");

        Quiz quiz = new Quiz(noOfQuestions);
        quiz.runQuiz();
    }
}
