package com.pokeapi.POKEDEX.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private String name;
    private String photoUrl;
    private List<PokemonType> types;
    private int weight;
    private List<PokemonAbility> abilities;

}
