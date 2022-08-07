package com.mycompany.pokeapiapp;

public class Constants {
    private static final String API_ADDRESS = "https://pokeapi.co/api/v2/";
    private static final String API_ADDRESS_FOR_POKEMON = API_ADDRESS + "pokemon/";
    
    public static String getApiAddress() {
        return API_ADDRESS;
    }

    public static String getApiAddressForPokemon() {
        return API_ADDRESS_FOR_POKEMON;
    }
    
    
}
