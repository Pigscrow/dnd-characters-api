package com.nahuel.dnd_characters_api.dto;

public record SkillRollResponse(
        String character,
        String skill,
        int roll,
        int modifier,
        int total,
        String details
) {}