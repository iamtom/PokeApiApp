package com.mycompany.pokemonquizapp;

import com.mycompany.pokemon.Pokemon;
import java.util.Random;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestTest {
    
    private Request request;
    
   
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("Running: set up");
        request = new Request();
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Running: tear down");
        request = null;
        assertNull(request);
    }
    
    @Test //TO DO
    public void testPokemonAsJson() {
        System.out.println("pokemonAsJson");
        String searchFor = "";
        Request instance = new Request();
        String expResult = "";
        String result = instance.pokemonAsJson(searchFor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSearchPokemon_String() {
        System.out.println("Running: searchPokemon(String searchFor) test");
        String searchFor = "bulbasaur";
        
        String expName = "bulbasaur";
        
        Pokemon pokemon = request.searchPokemon(searchFor);
        String name = pokemon.getName();
        
        assertEquals(expName, name);
    }
    
    @Test
    public void testSearchPokemon_int() {
        System.out.println("Running: searchPokemon(int id) test");
        int id = 1;
        
        String expName = "bulbasaur";
        
        Pokemon pokemon = request.searchPokemon(id);
        String name = pokemon.getName();
        
        assertEquals(expName, name);
    }
    
    @Test
    public void testNoOfPokemon() {
        System.out.println("Running: noOfPokemon test");
        int expResult = 905;
        int result = request.noOfPokemon();
        assertEquals(expResult, result);   
    }

    @Test
    public void testRandomPokemon() {       
        System.out.println("Running: randomPokemon test");
        String expName = "bulbasaur";
            
        int max = request.noOfPokemon();
        
        Random fakeRandom = mock(Random.class);
        when(fakeRandom.nextInt(max + 1)).thenReturn(1);        
        
        request.setRandomUtil(fakeRandom);
        
        Pokemon pokemon = request.randomPokemon();
        
        String name = pokemon.getName();
        
        assertEquals(expName, name);
    }  
}
