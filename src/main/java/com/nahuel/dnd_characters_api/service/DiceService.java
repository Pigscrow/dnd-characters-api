package com.nahuel.dnd_characters_api.service;

import com.nahuel.dnd_characters_api.client.DiceClient;
import com.nahuel.dnd_characters_api.dto.SkillRollResponse;
import com.nahuel.dnd_characters_api.exception.InvalidSkillException;
import com.nahuel.dnd_characters_api.model.Character;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DiceService {

    private final DiceClient diceClient;
    private final CharacterService characterService;

    private static final Set<String> VALID_SKILLS = Set.of(
            "strength", "dexterity", "constitution",
            "intelligence", "wisdom", "charisma"
    );

    public DiceService(DiceClient diceClient, CharacterService characterService) {
        this.diceClient = diceClient;
        this.characterService = characterService;
    }

    public SkillRollResponse rollSkill(Long characterId, String skill) {
        // Validate skill
        if (!VALID_SKILLS.contains(skill.toLowerCase())) {
            throw new InvalidSkillException(skill);
        }

        // Get character
        Character character = characterService.getById(characterId);

        // Get stat value
        int statValue = getStatValue(character, skill.toLowerCase());

        // Calculate D&D modifier: (stat - 10) / 2
        int modifier = (statValue - 10) / 2;

        // Roll 1d20 with Feign
        String rawResponse = diceClient.roll("1d20", "");
        int roll = parseResult(rawResponse);

        // Calculate total
        int total = roll + modifier;

        return new SkillRollResponse(
                character.getName(),
                skill.toLowerCase(),
                roll,
                modifier,
                total,
                "1d20[" + roll + "] + modifier(" + modifier + ") = " + total
        );
    }

    private int getStatValue(Character character, String skill) {
        return switch (skill) {
            case "strength"     -> character.getStrength();
            case "dexterity"    -> character.getDexterity();
            case "constitution" -> character.getConstitution();
            case "intelligence" -> character.getIntelligence();
            case "wisdom"       -> character.getWisdom();
            case "charisma"     -> character.getCharisma();
            default -> throw new InvalidSkillException(skill);
        };
    }

    private int parseResult(String rawResponse) {
        for (String line : rawResponse.split("\n")) {
            if (line.startsWith("result=")) {
                return Integer.parseInt(line.replace("result=", "").trim());
            }
        }
        throw new RuntimeException("Could not parse dice roll result");
    }
}