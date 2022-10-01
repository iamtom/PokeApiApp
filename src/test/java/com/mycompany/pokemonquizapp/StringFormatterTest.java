package com.mycompany.pokemonquizapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringFormatterTest {
    
    @Test
    public void testBasicFormat() {
        System.out.println("format test");
        String original = "fire-blast";
        String result = StringFormatter.basicFormat(original);
        String expResult = "Fire Blast";
        assertEquals(expResult, result);
    }
}
