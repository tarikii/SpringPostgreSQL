package com.example.SpringPostgreSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    CharacterDAO repository;
    public List<Character> findAll() {
        return repository.findAll();
    }

    public Character getCharacterById(Integer id) {
        Optional<Character> optionalCharacter;
        optionalCharacter = repository.findById(id);
        return optionalCharacter.orElse(null);
    }

    public Character newCharacter(Character character) {
        return repository.save(character);
    }

    public void removeCharacter(Integer characterId){
        repository.deleteById(characterId);
    }


    public Character updateCharacter(Integer id, Character character) {
        Optional<Character> optionalCharacter = repository.findById(id);
        if (optionalCharacter.isPresent()) {
            Character existingCharacter = optionalCharacter.get();
            // Actualizamos el nombre
            existingCharacter.setName(character.getName());
            return repository.save(existingCharacter);
        } else {
            return null;
        }
    }
}