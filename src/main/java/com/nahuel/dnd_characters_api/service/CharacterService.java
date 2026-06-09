package com.nahuel.dnd_characters_api.service;

import com.nahuel.dnd_characters_api.dto.CharacterRequest;
import com.nahuel.dnd_characters_api.exception.CharacterNotFoundException;
import com.nahuel.dnd_characters_api.model.Character;
import com.nahuel.dnd_characters_api.repository.CharacterRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public Page<Character> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Character getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    public Character create(CharacterRequest request) {
        Character character = new Character(
                request.name(),
                request.race(),
                request.characterClass(),
                request.strength(),
                request.dexterity(),
                request.constitution(),
                request.intelligence(),
                request.wisdom(),
                request.charisma()
        );
        return repository.save(character);
    }

    public Character update(Long id, CharacterRequest request) {
        Character character = getById(id);
        character.setName(request.name());
        character.setRace(request.race());
        character.setCharacterClass(request.characterClass());
        character.setStrength(request.strength());
        character.setDexterity(request.dexterity());
        character.setConstitution(request.constitution());
        character.setIntelligence(request.intelligence());
        character.setWisdom(request.wisdom());
        character.setCharisma(request.charisma());
        return repository.save(character);
    }

    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }
}