package com.pokeapi.POKEDEX.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class PokemonDetails {
    private String name;
    private String photoUrl;
    private List<PokemonType> types;
    private int weight;
    private List<PokemonAbility> abilities;
    private List<PokemonMove> moves;
    private String description;

    @JsonProperty("sprites")
    private Map<String, Object> sprites;

    public void setSprites(Map<String, Object> sprites) {
        this.sprites = sprites;
        if (sprites != null) {
            Object other = sprites.get("other");
            if (other instanceof Map) {
                Map<String, Object> otherSprites = (Map<String, Object>) other;
                Object dreamWorld = otherSprites.get("dream_world");
                if (dreamWorld instanceof Map) {
                    Map<String, Object> dreamWorldSprites = (Map<String, Object>) dreamWorld;
                    Object frontDefault = dreamWorldSprites.get("front_default");
                    if (frontDefault instanceof String) {
                        this.photoUrl = (String) frontDefault;
                    }
                }
            }
        }
    }
}