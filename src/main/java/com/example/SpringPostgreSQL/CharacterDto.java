package com.example.SpringPostgreSQL;

import lombok.Data;

@Data
public class CharacterDto {
    int characterId;
    int characterTypeId;
    int weaponId;
    String name;
    String image;
    String health;
    String variant;
    String abilities;
    String FPSClass;


    public CharacterDto(int characterId, int characterTypeId, int weaponId, String name, String image, String health, String variant, String abilities, String FPSClass) {
        this.characterId = characterId;
        this.characterTypeId = characterTypeId;
        this.weaponId = weaponId;
        this.name = name;
        this.image = image;
        this.health = health;
        this.variant = variant;
        this.abilities = abilities;
        this.FPSClass = FPSClass;
    }

    public CharacterDto(Character character){
        this.characterId = character.getCharacterId();
        this.characterTypeId = character.getCharacterTypeId();
        this.weaponId = character.getWeaponId();
        this.name = character.getName();
        this.image = character.getImage();
        this.health = character.getHealth();
        this.variant = character.getVariant();
        this.abilities = character.getAbilities();
        this.FPSClass = character.getFPSClass();
    }
}
