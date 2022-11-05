package com.mycompany.pokemonquizapp;

public class StringFormatter {
    public static String basicFormat(String input) {
        //the API returns lower case strings with "-" instead of spaces
        //e.g. flare-blitz becomes Flare Blitz
        String result;
        
        String[] array = input.split("-");
        
        //capitalise first letter of each string
        for (int i = 0; i < array.length; i++) {
            String firstLetter = array[i].substring(0, 1);
            firstLetter = firstLetter.toUpperCase();
            String restOfWord = array[i].substring(1);
            array[i] = firstLetter.concat(restOfWord);            
        }
        
        result = String.join(" ", array);
        
        return result;
    }
    
    public static String formatVersionName(String input) {
        //TODO account for black-2-white-2, omega-ruby-alpha-sapphire, ultra-sun-ultra-moon
        //lets-go-pikachu-lets-go-eevee, 
        
        String versionName = basicFormat(input);
        
        if (versionName.contains(" ")) {
            versionName = versionName.replace(" ", " & ");
        }
        
        if (versionName.equals("xd")) {
            versionName = "XD";
        }
              
        return versionName;
    }
}
