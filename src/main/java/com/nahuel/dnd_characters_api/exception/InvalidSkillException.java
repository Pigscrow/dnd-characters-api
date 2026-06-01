package com.nahuel.dnd_characters_api.exception;

public class InvalidSkillException extends RuntimeException {

    public InvalidSkillException(String skill) {
        super("Invalid skill '" + skill + "'. Valid skills are: strength, dexterity, constitution, intelligence, wisdom, charisma");
    }
}