package com.example.SpringPostgreSQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterDAO extends JpaRepository<Character,Integer> {
    List<Character> findAll();
    List<Character> findCharacterByName(String name);
}
