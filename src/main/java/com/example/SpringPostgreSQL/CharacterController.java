package com.example.SpringPostgreSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CharacterController {
    @Autowired
    CharacterService characterService;

    public List<CharacterData> getAllChracters() {
        List<Character> characters = characterService.findAll();
        List<CharacterData> characterDatos = characters.stream().map(CharacterData::new).toList();
        //List<CharacterDto> characterDtos = characters.stream().map(character -> new CharacterDto(character)).toList();
        return characterDatos;

    }
}