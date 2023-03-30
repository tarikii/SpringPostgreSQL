package com.example.SpringPostgreSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CharacterResource.CHARACTERS)
public class CharacterResource {
    public static final String CHARACTERS = "/characters";
    @Autowired
    CharacterController characterController;

    @GetMapping
    public List<CharacterData> readAll() {
        return characterController.getAllChracters();
    }
}

