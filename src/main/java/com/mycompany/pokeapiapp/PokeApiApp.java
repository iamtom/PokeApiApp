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
        ArrayList<PersonalAbilityInfo> abilities = pokemon.getAbilities();
        
        PersonalAbilityInfo abilityInfo = abilities.get(0);
        System.out.println(abilityInfo.getAbilitySimple());
        System.out.println(abilityInfo.getIsHidden());
        System.out.println(abilityInfo.getSlot());
        
        AbilitySimple ability = abilityInfo.getAbilitySimple();
        System.out.println(ability.getName());
        System.out.println(ability.getUrl());
        
        System.out.println(abilities.get(0).getAbilitySimple().getName());
        
        System.out.println(pokemon.getForms());
        
        System.out.println(pokemon.getBaseExperience());
       
        
        
        
        

        
//        System.out.println(abilities.get(0).getIs_hidden());
//        System.out.println(abilities.get(0).getSlot());
//        System.out.println(abilities.get(0).toString());
        
//        System.out.println("Ability Test");
//        Ability ability = abilities.get(0);
//        
//        System.out.println(ability.getName());
//        System.out.println(ability.getUrl());
//        System.out.println(ability.getIs_hidden());
//        System.out.println(ability.getSlot());
//        System.out.println(ability.toString());

//        Ability[] abilitiesTwo = pokemon.getAbilities();
//        
//        System.out.println("Array");
//        System.out.println(abilitiesTwo[0]);
//        System.out.println("To String");
//        System.out.println(abilitiesTwo[0].toString());
//        System.out.println("Name");
//        System.out.println(abilitiesTwo[0].getName());
//        System.out.println("Url");
//        System.out.println(abilitiesTwo[0].getUrl());
 

        
        
        
    }
}
