package com.example.SpringPostgreSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    CharacterDAO repository;
    public List<Character> findAll() {
        return repository.findAll();
    }

    public Character newCharacter(Character character) {
        return repository.save(character);
    }
}