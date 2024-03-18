package com.pokeapi.POKEDEX.model;

import lombok.Data;

@Data
public class PokemonAbility {
    private Ability ability;
    private boolean isHidden;
    private int slot;
}