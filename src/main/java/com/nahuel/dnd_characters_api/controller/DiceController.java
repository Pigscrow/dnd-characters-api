package com.nahuel.dnd_characters_api.controller;

import com.nahuel.dnd_characters_api.dto.SkillRollResponse;
import com.nahuel.dnd_characters_api.service.DiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
@Tag(name = "Dice", description = "Dice rolling endpoints")
public class DiceController {

    private final DiceService diceService;

    public DiceController(DiceService diceService) {
        this.diceService = diceService;
    }

    @GetMapping("/{id}/roll")
    @Operation(summary = "Roll a d20 skill check for a character")
    public SkillRollResponse rollSkill(
            @PathVariable Long id,
            @RequestParam String skill) {
        return diceService.rollSkill(id, skill);
    }
}