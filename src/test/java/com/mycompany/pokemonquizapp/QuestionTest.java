package com.mycompany.pokemonquizapp;

import com.mycompany.pokemon.Pokemon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        
        //TODO make it create the same question each time
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

    /**
     * Test of checkAnswer method, of class Question.
     */
    @Test
    public void testCheckAnswer() {
        //Check for both correct and incorrect answers
        System.out.println("checkAnswer");
        Question instance = null;
        Boolean expResult = null;
        Boolean result = instance.checkAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserAnswer method, of class Question.
     */
    @Test
    public void testSetUserAnswer() {
        System.out.println("setUserAnswer");
        Boolean userAnswer = null;
        Question instance = null;
        instance.setUserAnswer(userAnswer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
