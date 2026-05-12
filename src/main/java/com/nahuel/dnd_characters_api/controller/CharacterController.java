package com.nahuel.dnd_characters_api.controller;

import com.nahuel.dnd_characters_api.model.Character;
import com.nahuel.dnd_characters_api.repository.CharacterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterRepository repository;

    public CharacterController(CharacterRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Character> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Character getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Character create(@RequestBody Character character) {
        return repository.save(character);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}