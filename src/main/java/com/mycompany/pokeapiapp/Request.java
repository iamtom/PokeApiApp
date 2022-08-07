package com.mycompany.pokeapiapp;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Request {
        
    public Request () {
        
    }
    
    private String search(String address) {
        String jsonString = null;
        
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
            
            System.out.println(postResponse.statusCode()); //200 = found, 404 = not found
            //TO DO handle error codes with catch
            
            jsonString = postResponse.body();                      

        } catch (IOException | InterruptedException | URISyntaxException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jsonString; 
    }
    
    public String getPokemonAsJson (String searchFor) {
        String address = Constants.getApiAddressForPokemon() + searchFor;
        String response = search(address);
        
        return response;
    }
    
    public Pokemon getPokemon (String searchFor) {
        String response = getPokemonAsJson(searchFor);
               
        Gson gson = new Gson();

        Pokemon pokemon = gson.fromJson(response, Pokemon.class);
        return pokemon;        
    }
    
    
}
