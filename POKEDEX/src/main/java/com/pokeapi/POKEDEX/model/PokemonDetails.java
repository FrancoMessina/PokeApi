package com.pokeapi.POKEDEX.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class PokemonDetails {
    private String id;
    private String name;
    private List<PokemonType> types;
    private int weight;
    private List<PokemonAbility> abilities;
    private List<PokemonMove> moves;
    private String description;
    private String photoUrl;

    public void setPhotoUrl(){
        this.photoUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/"+this.id+".png";
    }

}