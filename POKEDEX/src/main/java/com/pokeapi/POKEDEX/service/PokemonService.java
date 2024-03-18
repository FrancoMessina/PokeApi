package com.pokeapi.POKEDEX.service;

import com.pokeapi.POKEDEX.exception.PokemonNotFoundException;
import com.pokeapi.POKEDEX.model.Pokemon;
import com.pokeapi.POKEDEX.model.PokemonDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
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
        // Aquí debes implementar la lógica para enriquecer la descripción en español
        // Puedes consultar la API de Pokémon nuevamente utilizando la URL específica de cada Pokémon
        // y agregar información adicional como tipo(s), peso, habilidades, movimientos, etc.
        // Por simplicidad, este ejemplo utilizará solo el nombre del Pokémon y la URL como placeholder
        description.append("Nombre: ").append(pokemon.getName());
        description.append(" Peso: ").append(pokemon.getWeight());
        description.append(" Tipo: ");
        pokemon.getTypes().forEach(type -> description.append(type.getType().getName()));
        return description.toString();
    }
}
