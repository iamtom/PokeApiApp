package com.mycompany.pokeapiapp;

/**
 *
 * @author Tom
 */
public class StatSimple {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }    

    @Override
    public String toString() {
        return "StatSimple{" + "name=" + name + ", url=" + url + '}';
    }
    
}
