package com.nahuel.dnd_characters_api.controller;

import com.nahuel.dnd_characters_api.dto.CharacterRequest;
import com.nahuel.dnd_characters_api.model.Character;
import com.nahuel.dnd_characters_api.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

@RestController
@RequestMapping("/characters")
@Tag(name = "Characters", description = "Endpoints for managing D&D characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all characters (paginated)")
    public Page<Character> getAll(
            @PageableDefault(size = 20, sort = "name") Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a character by ID")
    public Character getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new character")
    public Character create(@RequestBody @Valid CharacterRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing character")
    public Character update(@PathVariable Long id, @RequestBody @Valid CharacterRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a character")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}