package com.example.SpringPostgreSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CharacterResource.CHARACTERS)
public class CharacterResource {
    public static final String CHARACTERS = "/characters";
    @Autowired
    CharacterController characterController;

    @GetMapping
    public List<CharacterDto> readAll() {
        return characterController.getAllChracters();
    }

    @PostMapping
    public ResponseEntity<CharacterDto> createCharacter(@RequestBody Character character) {
        CharacterDto createdCharacter = characterController.addCharacter(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCharacter);
    }
}

