package com.mycompany.pokemonquizapp;

import com.mycompany.pokemon.Pokemon;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Request {
        
    public Request () {
        
    }
    
    private String search(String address) {
        String jsonString = null;
        //Pokemon names must be lower case or we get a 404
        //To lower case here rather than in all other search methods
        address = address.toLowerCase();

        try {
            HttpClient httpClient = HttpClient.newHttpClient();            
            
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(address))
                    .GET()          
                    .build();
            
            //this is where the response is stored as a string
            HttpResponse<String> postResponse;   

            //send the httpRequest (bodyhandlers.ofString tells it we expect a string in return)
            postResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            jsonString = postResponse.body();

        } catch (IOException | InterruptedException | URISyntaxException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jsonString; 
    }
    
    public String pokemonAsJson (String searchFor) {
        String address = Constants.getApiAddressForPokemon() + searchFor;
        String response = search(address);
        
        //System.out.println("JSON: ");
        //System.out.println(response);   
        
        return response;
    }
    
    public Pokemon searchPokemon (String searchFor) {
        //searchFor must either be Pokemon name or number
        String response = pokemonAsJson(searchFor);
               
        Gson gson = new Gson();
        
        Pokemon pokemon = gson.fromJson(response, Pokemon.class);
        return pokemon;        
    }
    
    public Pokemon searchPokemon (int id) {
        //searchFor must either be Pokemon name or number
        String searchFor = String.valueOf(id);
        String response = pokemonAsJson(searchFor);
               
        Gson gson = new Gson();

        Pokemon pokemon = gson.fromJson(response, Pokemon.class);
        return pokemon;        
    }
    
    public int noOfPokemon() {
        String address = Constants.getApiAddressForPokemonSpecies();
        String response = search(address);
        
        //remove everything around the count number (number of pokemon)
        String s = response.substring(9, 12);
        int number = Integer.valueOf(s);
        //System.out.println("Total number of Pokemon: " + number);
        
        return number; 
    }
    
    public Pokemon randomPokemon() {
        int max = noOfPokemon();
        
        Random random = new Random();
        int x = random.nextInt(max + 1);
        //System.out.println("Random ID: " + x);
        
        Pokemon pokemon = searchPokemon(x);
        
        return pokemon;
    }
    
    
}
