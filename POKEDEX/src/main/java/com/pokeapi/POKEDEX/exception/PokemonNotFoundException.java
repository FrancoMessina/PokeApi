package com.pokeapi.POKEDEX.exception;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}