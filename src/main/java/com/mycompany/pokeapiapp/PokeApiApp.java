package com.mycompany.pokeapiapp;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class PokeApiApp {

    public static void main(String[] args) {
        String searchTerm = "dragonite";
        
        Request request = new Request(searchTerm);
        String response = request.search();
        System.out.println(response);
        
        Gson gson = new Gson();
        
        //create Pokemon object from JSON
        Pokemon pokemon = gson.fromJson(response, Pokemon.class);
        System.out.println(pokemon.getAbilities());
        System.out.println(pokemon.getAbilities().get(0));
        System.out.println(pokemon.getAbilities().get(1));
        
        //list of all abilities
        ArrayList<PokemonAbilityInfo> abilities = pokemon.getAbilities();
        
        PokemonAbilityInfo abilityInfo = abilities.get(0);
        System.out.println(abilityInfo.getAbilitySimple());
        System.out.println(abilityInfo.getIsHidden());
        System.out.println(abilityInfo.getSlot());
        
        AbilitySimple ability = abilityInfo.getAbilitySimple();
        System.out.println(ability.getName());
        System.out.println(ability.getUrl());
        
        System.out.println(abilities.get(0).getAbilitySimple().getName());
        
        System.out.println("Game Indices");
        ArrayList<PokemonGameIndex> gameIndices = pokemon.getGameIndices();
        System.out.println(gameIndices);
        System.out.println(gameIndices.get(0).getVersion());
        
        System.out.println("Held Items");
        ArrayList<PokemonHeldItem> heldItems = pokemon.getHeldItems();
        System.out.println(heldItems.get(0).getItem().getName());
        System.out.println(heldItems.get(0).getVersionDetails().get(0).getVersion().getName());
        
        System.out.println("");
        System.out.println("Moves");
        ArrayList<PokemonMove> moves = pokemon.getMoves();
        
        //dragon-rush is learned at level 39 in diamond-pearl by level-up:
        int moveNo = 100;
        int versionNo = 0;       
        String moveName = moves.get(moveNo).getMove().getName();
        int levelLearned = moves.get(moveNo).getVersionGroupDetails().get(versionNo).getLevelLearnedAt();
        String learnMethod = moves.get(moveNo).getVersionGroupDetails().get(versionNo).getMoveLearnMethod().getName();
        String versionName = moves.get(moveNo).getVersionGroupDetails().get(versionNo).getVersionGroup().getName();
        System.out.println(moveName + " is learned at level " + levelLearned + " in " + versionName + " by " + learnMethod);
        
        System.out.println("");
        System.out.println("Types");
        ArrayList<PokemonType> types = pokemon.getTypes();
        String type1 = types.get(0).getType().getName();
        String type2 = types.get(1).getType().getName();
        System.out.println("Type 1: " + type1 + ". Type 2: " + type2 +".");

        System.out.println("");
        System.out.println("Stats");
        ArrayList<PokemonStat> stats = pokemon.getStats();
        int hp = stats.get(0).getBaseStat();
        int attack = stats.get(1).getBaseStat();
        int defense = stats.get(2).getBaseStat();
        int specAttack = stats.get(3).getBaseStat();
        int specDefense = stats.get(4).getBaseStat();
        int speed = stats.get(5).getBaseStat();
        System.out.println("HP " + hp + ", Attack " + attack + ", Defense " + defense + ", Special Attack " + specAttack + ", Special Defense " + specDefense + ", Speed " + speed);
        
    }
}
