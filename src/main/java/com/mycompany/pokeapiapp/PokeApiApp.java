package com.mycompany.pokeapiapp;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Scanner;

public class PokeApiApp {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Pokemon name and press enter:");
            String searchFor = scanner.nextLine();
            
            if (searchFor.equals("")) {
                System.out.println("Input not valid.");
                System.out.println("");
                continue;
            }
            
            Request request = new Request();
            Pokemon pokemon = request.getPokemon(searchFor);
            
            //quick test
            ArrayList<PokemonMove> moves = pokemon.getMoves();            
            int moveNo = moves.size() - 1;
            int versionNo = 0;       
            String moveName = moves.get(moveNo).getMove().getName();
            int levelLearned = moves.get(moveNo).getVersionGroupDetails().get(versionNo).getLevelLearnedAt();
            String learnMethod = moves.get(moveNo).getVersionGroupDetails().get(versionNo).getMoveLearnMethod().getName();
            String versionName = moves.get(moveNo).getVersionGroupDetails().get(versionNo).getVersionGroup().getName();
            System.out.println(moveName + " is learned at level " + levelLearned + " in " + versionName + " by " + learnMethod);

            
        }

    }
}
