package com.example.SpringPostgreSQL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

import java.util.List;

@Controller
public class CharacterController {
    @Autowired
    CharacterService characterService;
    @Autowired
    ObjectMapper objectMapper;

    public List<CharacterDto> getAllChracters() {
        List<Character> characters = characterService.findAll();
        List<CharacterDto> characterDatos = characters.stream().map(CharacterDto::new).toList();
        //List<CharacterDto> characterDtos = characters.stream().map(character -> new CharacterDto(character)).toList();
        return characterDatos;
    }

    public CharacterDto getCharacterById(int characterId){
        Character character = characterService.getCharacterById(characterId);
        return new CharacterDto(character);
    }

    public CharacterDto addCharacter(Character characterDto) {
        Character character = characterService.newCharacter(characterDto);
        return new CharacterDto(character);
    }

    public void takeOutCharacter(Integer characterId){
        characterService.removeCharacter(characterId);
    }

    public Character updateCharacter(Integer characterId, Character character) {
        return characterService.updateCharacter(characterId, character);
    }

    public CharacterDto patchCharacter(Integer characterId, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        Optional<Character> optionalCharacter = Optional.ofNullable(characterService.getCharacterById(characterId));

        if (optionalCharacter.isPresent()) {
            Character character = optionalCharacter.get();
            JsonNode patchedCharacterJson = patch.apply(objectMapper.convertValue(character, JsonNode.class));
            Character patchedCharacter = objectMapper.treeToValue(patchedCharacterJson, Character.class);
            Character updatedCharacter = characterService.updateCharacter(characterId, patchedCharacter);
            return new CharacterDto(updatedCharacter);
        } else {
            throw new JsonPatchException("Character with id " + characterId + " not found");
        }
    }
}