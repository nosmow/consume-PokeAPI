package com.nosmow.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAbility(
        Ability ability,
        @JsonAlias("is_hidden")
        boolean isHidden,
        int slot
) {
}
