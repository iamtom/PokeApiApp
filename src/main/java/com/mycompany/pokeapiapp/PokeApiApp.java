package com.mycompany.pokeapiapp;

import com.google.gson.Gson;
import java.lang.reflect.Array;
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
 

        
        
        
    }
}
