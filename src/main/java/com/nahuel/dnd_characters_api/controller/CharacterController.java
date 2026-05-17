package com.nahuel.dnd_characters_api.controller;

import com.nahuel.dnd_characters_api.dto.CharacterRequest;
import com.nahuel.dnd_characters_api.model.Character;
import com.nahuel.dnd_characters_api.service.CharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    public List<Character> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Character getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Character create(@RequestBody @Valid CharacterRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public Character update(@PathVariable Long id, @RequestBody @Valid CharacterRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}