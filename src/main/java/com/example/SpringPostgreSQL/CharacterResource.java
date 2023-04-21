package com.example.SpringPostgreSQL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @GetMapping("{id}")
    public CharacterDto getCharacter(@PathVariable Integer id) {
        return characterController.getCharacterById(id);
    }

    @GetMapping("{id}/name")
    public Map<String,String> name(@PathVariable Integer id) {
        return Collections.singletonMap("name",characterController.getCharacterById(id).getName());
    }

    @PostMapping
    public ResponseEntity<CharacterDto> createCharacter(@RequestBody Character character) {
        CharacterDto createdCharacter = characterController.addCharacter(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCharacter);
    }

    @DeleteMapping("{characterId}")
    public ResponseEntity<CharacterDto> deleteCharacter(@PathVariable Integer characterId) {
        characterController.takeOutCharacter(characterId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{characterId}")
    public ResponseEntity<CharacterDto> updateCharacter(@PathVariable Integer characterId, @RequestBody Character character) {
        Character updatedCharacter = characterController.updateCharacter(characterId, character);
        if (updatedCharacter == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(new CharacterDto(updatedCharacter));
        }
    }

    @PatchMapping("{characterId}")
    public ResponseEntity<CharacterDto> patchCharacter(@PathVariable Integer characterId, @RequestBody JsonPatch patch) {
        try {
            CharacterDto updatedCharacter = characterController.patchCharacter(characterId, patch);
            return ResponseEntity.ok(updatedCharacter);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}