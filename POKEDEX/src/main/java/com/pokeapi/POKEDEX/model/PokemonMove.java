package com.pokeapi.POKEDEX.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class PokemonMove {
    private Move move;
}
