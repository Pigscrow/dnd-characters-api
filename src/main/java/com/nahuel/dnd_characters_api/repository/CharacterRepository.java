package com.nahuel.dnd_characters_api.repository;

import com.nahuel.dnd_characters_api.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    // No necesitás escribir nada acá
    // JpaRepository te da gratis:
    // findAll()        → SELECT * FROM characters
    // findById(id)     → SELECT * FROM characters WHERE id = ?
    // save(character)  → INSERT o UPDATE automáticamente
    // deleteById(id)   → DELETE FROM characters WHERE id = ?
}