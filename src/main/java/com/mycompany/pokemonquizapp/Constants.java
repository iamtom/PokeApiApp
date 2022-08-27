package com.mycompany.pokemonquizapp;

public class Constants {
    private static final String API_ADDRESS = "https://pokeapi.co/api/v2/";
    private static final String API_ADDRESS_FOR_POKEMON = API_ADDRESS + "pokemon/";
    private static final String API_ADDRESS_FOR_POKEMON_SPECIES = API_ADDRESS + "pokemon-species/";
    
    public static String getApiAddress() {
        return API_ADDRESS;
    }

    public static String getApiAddressForPokemon() {
        return API_ADDRESS_FOR_POKEMON;
    }

    public static String getApiAddressForPokemonSpecies() {
        return API_ADDRESS_FOR_POKEMON_SPECIES;
    }
    
    
}
