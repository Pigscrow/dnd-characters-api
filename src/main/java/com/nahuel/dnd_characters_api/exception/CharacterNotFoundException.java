package com.nahuel.dnd_characters_api.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(Long id) {
        super("Character with id " + id + " not found");
    }
}
