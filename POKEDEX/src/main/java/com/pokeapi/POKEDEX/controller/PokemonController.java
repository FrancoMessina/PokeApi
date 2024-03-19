package com.pokeapi.POKEDEX.controller;

import com.pokeapi.POKEDEX.model.Pokemon;
import com.pokeapi.POKEDEX.model.PokemonDetails;
import com.pokeapi.POKEDEX.service.PokemonService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;


    @GetMapping("/details/{name}")
    public PokemonDetails getPokemonDetails(@PathVariable String name) {
        PokemonDetails poke =  pokemonService.getPokemonDetails(name);
        return poke;
    }
    @GetMapping("/{name}")
    public Pokemon getPokemon(@PathVariable String name) {
        return pokemonService.getPokemon(name);
    }


    @GetMapping("/all")
    public ResponseEntity<Page<PokemonDetails>> getPokemonPage(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<PokemonDetails> pokemonPage = pokemonService.getAllPokemon(page, size);
        return ResponseEntity.ok().body(pokemonPage);
    }
}
