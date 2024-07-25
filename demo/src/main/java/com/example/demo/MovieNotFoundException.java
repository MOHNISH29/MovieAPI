package com.example.demo;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException()
    {
        super("Movie was not Found with given Id");
    }
}
