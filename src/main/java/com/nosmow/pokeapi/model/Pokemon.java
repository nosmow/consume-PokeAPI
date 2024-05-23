package com.nosmow.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pokemon(
        String name,
        List<DataType> types,
        List<DataAbility> abilities
) {
}
