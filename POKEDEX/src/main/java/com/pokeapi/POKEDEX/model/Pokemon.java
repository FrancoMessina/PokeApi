package com.pokeapi.POKEDEX.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokeapi.POKEDEX.Utils.Util;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private String id;
    private String name;
    private String photoUrl;
    private List<PokemonType> types;
    private int weight;
    private List<PokemonAbility> abilities;
    public void setPhotoUrl(){
        this.photoUrl =   Util.URL_IMG +this.id+Util.IMG_PNG;
    }

}
