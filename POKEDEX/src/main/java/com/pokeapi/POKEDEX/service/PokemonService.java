package com.pokeapi.POKEDEX.service;

import com.pokeapi.POKEDEX.exception.PokemonNotFoundException;
import com.pokeapi.POKEDEX.model.Pokemon;
import com.pokeapi.POKEDEX.model.PokemonDetails;
import com.pokeapi.POKEDEX.model.PokemonInfo;
import com.pokeapi.POKEDEX.model.PokemonListResponse;
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
            // Obtener la descripción en español utilizando los detalles del Pokémon
            String descriptionSpanish = this.getDescriptionSpanish(responseEntity.getBody());
            // Establecer la descripción en español en los detalles del Pokémon
            responseEntity.getBody().setDescription(descriptionSpanish);
            responseEntity.getBody().setPhotoUrl();
        }
        return Optional.ofNullable(responseEntity.getBody()).orElse(new PokemonDetails());
    }
    public Pokemon getPokemon(String name) {
        String url = pokeApiBaseUrl + "/pokemon/" + name;
        ResponseEntity<Pokemon> responseEntity = restTemplate.getForEntity(url, Pokemon.class);
        return Optional.ofNullable(responseEntity.getBody()).orElse(new Pokemon());
    }

    private String getDescriptionSpanish(PokemonDetails pokemon) {
        StringBuilder description = new StringBuilder();
        description.append("Nombre: ").append(pokemon.getName());
        description.append(" Peso: ").append(pokemon.getWeight());
        description.append(" Tipo: ");
        pokemon.getTypes().forEach(type -> description.append(type.getType().getName()).append(" "));
        return description.toString();
    }
    public Page<PokemonDetails> getAllPokemon(int page, int size) {
        String url = "https://pokeapi.co/api/v2/pokemon?offset=" + (page - 1) * size + "&limit=" + size;
        ResponseEntity<PokemonListResponse> responseEntity = restTemplate.getForEntity(url, PokemonListResponse.class);
        PokemonListResponse pokemonListResponse = responseEntity.getBody();
        assert pokemonListResponse != null;
        List<PokemonDetails> pokemons = pokemonListResponse.getResults().stream().map(pokemonInfo -> this.getPokemonDetails(pokemonInfo.getName())).toList();
        return new PageImpl<>(pokemons, PageRequest.of(page - 1, size), pokemonListResponse.getCount());
    }
}
