package com.mycompany.pokeapiapp;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom
 */
public class Request {
    private final String searchTerm;
    
    public Request (String searchTerm) {
        this.searchTerm = searchTerm;
    }
    
    public String search() {
        String jsonString = null;
        
        try {
            HttpClient httpClient = HttpClient.newHttpClient();            
            
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://pokeapi.co/api/v2/pokemon/" + searchTerm))
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
}
