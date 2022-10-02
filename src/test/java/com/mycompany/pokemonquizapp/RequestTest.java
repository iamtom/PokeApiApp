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

    /**
     * Test of pokemonAsJson method, of class Request.
     */
    //@Test
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
    
    //TODO
    /**
     * Test of searchPokemon method, of class Request.
     */
    //@Test
    public void testSearchPokemon_String() {
        System.out.println("searchPokemon");
        String searchFor = "";
        Request instance = new Request();
        Pokemon expResult = null;
        Pokemon result = instance.searchPokemon(searchFor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of searchPokemon method, of class Request.
     */
    //@Test
    public void testSearchPokemon_int() {
        System.out.println("searchPokemon");
        int id = 0;
        Request instance = new Request();
        Pokemon expResult = null;
        Pokemon result = instance.searchPokemon(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of noOfPokemon method, of class Request.
     */
    @Test
    public void testNoOfPokemon() {
        System.out.println("Running: noOfPokemon test");
        int expResult = 905;
        int result = request.noOfPokemon();
        assertEquals(expResult, result);   
    }

    /**
     * Test of randomPokemon method, of class Request.
     */
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
