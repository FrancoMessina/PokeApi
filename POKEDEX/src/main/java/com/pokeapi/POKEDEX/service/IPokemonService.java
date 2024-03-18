package com.pokeapi.POKEDEX.service;

import com.pokeapi.POKEDEX.model.Pokemon;
import com.pokeapi.POKEDEX.model.PokemonDetails;

import java.util.List;

public interface IPokemonService {
    public PokemonDetails getPokemonDetails(String name);
    public Pokemon getPokemon(String name);

}
