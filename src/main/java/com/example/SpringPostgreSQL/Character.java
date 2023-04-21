package com.example.SpringPostgreSQL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "characters")
public class Character {

    @Id
    @Column(name = "id_character")
    int characterId;
    @Column(name = "id_character_type")
    int characterTypeId;
    @Column(name = "id_weapon")
    int weaponId;
    @Column(name = "name")
    String name;
    @Column(name = "image")
    String image;
    @Column(name = "health")
    String health;
    @Column(name = "variant")
    String variant;
    @Column(name = "abilities")
    String abilities;
    @Column(name = "FPSClass")
    String FPSClass;


    public Character() {
        super();
    }

    public Character(int characterId, int characterTypeId, int weaponId, String name, String image, String health, String variant, String abilities, String FPSClass) {
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

    public Character(CharacterDto characterData) {
        this.characterId = characterData.getCharacterId();
        this.characterTypeId = characterData.getCharacterTypeId();
        this.weaponId = characterData.getWeaponId();
        this.name = characterData.getName();
        this.image = characterData.getImage();
        this.health = characterData.getHealth();
        this.variant = characterData.getVariant();
        this.abilities = characterData.getAbilities();
        this.FPSClass = characterData.getFPSClass();
    }
}