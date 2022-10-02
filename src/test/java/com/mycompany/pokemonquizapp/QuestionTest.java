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

public class QuestionTest {
    
    private Question question;
    private Request request;
    private Pokemon pokemon;
    
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
        pokemon = request.searchPokemon(1);
        
        int maxMoves = pokemon.getMoves().size();        
        Random fakeRandom = mock(Random.class);
        when(fakeRandom.nextInt(maxMoves - 1)).thenReturn(4); //this is Vine Whip                
        pokemon.setRandomUtil(fakeRandom);
        
        //Make pokemon always return same random move
        //therefore can test all properties of the Question to check constructor works
        //except the random change of correct answer...
        try {
            question = new Question(pokemon);
        } catch (Exception e) {
            //exception won't happen as it is known this Pokemon has moves
        }      
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Running: tear down");
        request = null;
        pokemon = null;
        question = null;
        
        assertNull(request);
        assertNull(pokemon);
        assertNull(question);
    }

    @Test
    public void testConstructor() {
        
    }
    
    
    @Test
    public void testCheckAnswer() {
        System.out.println("Running: checkAnswer test");
        
        //Correct answer given
        question.setCorrectAnswer(true);
        question.setUserAnswer(true);
        Boolean expResult = true;
        Boolean result = question.checkAnswer();
        assertEquals(expResult, result);
        
        //Incorrect answer given
        question.setCorrectAnswer(true);
        question.setUserAnswer(false);
        expResult = false;
        result = question.checkAnswer();
        assertEquals(expResult, result);        
    }

}
