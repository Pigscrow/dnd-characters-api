package com.nahuel.dnd_characters_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DiceRollResult(
        @JsonProperty("result") int result,
        @JsonProperty("details") String details,
        @JsonProperty("input") String input
) {}