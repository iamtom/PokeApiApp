package com.mycompany.pokemonquizapp;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.pokemon.Pokemon;
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
            System.out.println(e.getMessage());
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
    public void testCheckAnswer() {
        System.out.println("Running: checkAnswer test");
        
        //Correct answer given
        this.question.setCorrectAnswer(true);
        this.question.setUserAnswer(true);
        Boolean expResult = true;
        Boolean result = this.question.checkAnswer();
        assertEquals(expResult, result);
        
        //Incorrect answer given
        this.question.setCorrectAnswer(true);
        this.question.setUserAnswer(false);
        expResult = false;
        result = this.question.checkAnswer();
        assertEquals(expResult, result);  
    }
  
}
