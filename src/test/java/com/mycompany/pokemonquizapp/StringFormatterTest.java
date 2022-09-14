package com.mycompany.pokemonquizapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringFormatterTest {
    
    @Test
    public void testFormat() {
        System.out.println("format");
        String original = "fire-blast";
        String result = StringFormatter.format(original);
        String expResult = "Fire Blast";
        assertEquals(expResult, result);
    }
}
