package com.mycompany.pokeapiapp;

/**
 *
 * @author Tom
 */
public class TypeSimple {
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
        return "TypeSimple{" + "name=" + name + ", url=" + url + '}';
    }
    
}
