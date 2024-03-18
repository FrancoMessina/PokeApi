package com.pokeapi.POKEDEX.controller;

import com.pokeapi.POKEDEX.model.Pokemon;
import com.pokeapi.POKEDEX.model.PokemonDetails;
import com.pokeapi.POKEDEX.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;


    @GetMapping("/details/{name}")
    public PokemonDetails getPokemonDetails(@PathVariable String name) {
        return pokemonService.getPokemonDetails(name);
    }
    @GetMapping("/{name}")
    public Pokemon getPokemon(@PathVariable String name) {
        return pokemonService.getPokemon(name);
    }
}
