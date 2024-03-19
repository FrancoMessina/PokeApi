package com.pokeapi.POKEDEX.service;

import com.pokeapi.POKEDEX.model.Pokemon;
import com.pokeapi.POKEDEX.model.PokemonDetails;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPokemonService {
    public PokemonDetails getPokemonDetails(String name);
    public Pokemon getPokemon(String name);
    public Page<PokemonDetails> getAllPokemonDetails(int page, int size);
    public Page<Pokemon> getAllPokemon(int page, int size);

}
