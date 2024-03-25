package com.pokeapi.POKEDEX.service;

import com.pokeapi.POKEDEX.exception.PokemonNotFoundException;
import com.pokeapi.POKEDEX.model.Pokemon;
import com.pokeapi.POKEDEX.model.PokemonDetails;
import com.pokeapi.POKEDEX.model.PokemonInfo;
import com.pokeapi.POKEDEX.model.PokemonListResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;


@Service
public class PokemonService implements IPokemonService {

    @Value("${pokeapi.base-url}")
    private String pokeApiBaseUrl;

    private final RestTemplate restTemplate;

    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public PokemonDetails getPokemonDetails(String name) {
        String url = pokeApiBaseUrl + "/pokemon/" + name;
        ResponseEntity<PokemonDetails> responseEntity = restTemplate.getForEntity(url, PokemonDetails.class);
        if (responseEntity.getBody() != null) {

            String descriptionSpanish = this.getDescriptionSpanish(responseEntity.getBody());
            responseEntity.getBody().setDescription(descriptionSpanish);
            responseEntity.getBody().setPhotoUrl();
        }
        return responseEntity.getBody();
    }
    public Pokemon getPokemon(String name) {
        String url = pokeApiBaseUrl + "/pokemon/" + name;
        ResponseEntity<Pokemon> responseEntity = restTemplate.getForEntity(url, Pokemon.class);
        if (responseEntity.getBody() != null) {
            responseEntity.getBody().setPhotoUrl();
        }
        return responseEntity.getBody();
    }

    private String getDescriptionSpanish(PokemonDetails pokemon) {
        StringBuilder description = new StringBuilder();
        description.append("Nombre: ").append(pokemon.getName());
        description.append(" Peso: ").append(pokemon.getWeight());
        description.append(" Tipo: ");
        pokemon.getTypes().forEach(type -> description.append(type.getType().getName()).append(" "));
        return description.toString();
    }
    public Page<PokemonDetails> getAllPokemonDetails(int page, int size) {
        String url = pokeApiBaseUrl+"/pokemon?offset=" + (page - 1) * size + "&limit=" + size;
        ResponseEntity<PokemonListResponse> responseEntity = restTemplate.getForEntity(url, PokemonListResponse.class);
        PokemonListResponse pokemonListResponse = responseEntity.getBody();
        assert pokemonListResponse != null;
        List<PokemonDetails> pokemons = pokemonListResponse.getResults().stream().map(pokemonInfo -> this.getPokemonDetails(pokemonInfo.getName())).toList();
        return new PageImpl<>(pokemons, PageRequest.of(page - 1, size), pokemonListResponse.getCount());
    }
    @Cacheable
    public Page<Pokemon> getAllPokemon(int page, int size) {
        String url = pokeApiBaseUrl+"/pokemon?offset=" + (page - 1) * size + "&limit=" + size;
        ResponseEntity<PokemonListResponse> responseEntity = restTemplate.getForEntity(url, PokemonListResponse.class);
        PokemonListResponse pokemonListResponse = responseEntity.getBody();
        assert pokemonListResponse != null;
        List<Pokemon> pokemons = pokemonListResponse.getResults().stream().map(pokemonInfo -> this.getPokemon(pokemonInfo.getName())).toList();
        return new PageImpl<>(pokemons, PageRequest.of(page - 1, size), pokemonListResponse.getCount());
    }
}
