package com.nahuel.dnd_characters_api.dto;

import jakarta.validation.constraints.*;

public record CharacterRequest(

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Race is required")
        String race,

        @NotBlank(message = "Character class is required")
        String characterClass,

        @Min(value = 1, message = "Strength must be between 1 and 20")
        @Max(value = 20, message = "Strength must be between 1 and 20")
        int strength,

        @Min(value = 1, message = "Dexterity must be between 1 and 20")
        @Max(value = 20, message = "Dexterity must be between 1 and 20")
        int dexterity,

        @Min(value = 1, message = "Constitution must be between 1 and 20")
        @Max(value = 20, message = "Constitution must be between 1 and 20")
        int constitution,

        @Min(value = 1, message = "Intelligence must be between 1 and 20")
        @Max(value = 20, message = "Intelligence must be between 1 and 20")
        int intelligence,

        @Min(value = 1, message = "Wisdom must be between 1 and 20")
        @Max(value = 20, message = "Wisdom must be between 1 and 20")
        int wisdom,

        @Min(value = 1, message = "Charisma must be between 1 and 20")
        @Max(value = 20, message = "Charisma must be between 1 and 20")
        int charisma

) {}