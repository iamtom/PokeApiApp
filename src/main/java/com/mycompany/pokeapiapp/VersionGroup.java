package com.mycompany.pokeapiapp;

public class VersionGroup {
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
        return "VersionGroup{" + "name=" + name + ", url=" + url + '}';
    }      
}
