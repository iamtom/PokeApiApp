package com.mycompany.pokeapiapp;

public class PokeApiApp {

    public static void main(String[] args) {      
        for (int i = 0; i < 30; i++) {
            TrueFalseQuestion question = new TrueFalseQuestion();
            System.out.println(question.getQuestion());            
        }

//        Request request = new Request();
//        
//        Pokemon pokemon = request.searchPokemon(255);
//        System.out.println(pokemon.getMoves());
        




    }

}
