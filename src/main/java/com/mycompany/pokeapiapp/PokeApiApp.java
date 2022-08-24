package com.mycompany.pokeapiapp;

import java.util.Scanner;

public class PokeApiApp {

    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Pokemon Move Quiz!");
            System.out.println("How many questions would you like to answer?");
            System.out.println("Enter a number and press enter:");
            int noOfQuestions = Integer.valueOf(scanner.nextLine());

            Quiz quiz = new Quiz(noOfQuestions);
            quiz.runQuiz();
            
            System.out.println("Play again? Y/N");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

}
