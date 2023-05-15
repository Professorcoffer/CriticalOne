package com.pe.criticalOne.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SpellEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "distance")
    private int distance;

    @Column(name = "damage")
    private String damage;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "damage_type", nullable = false)
    private int damageType;

    @Column(name = "classes", nullable = false)
    private String classes;

    @Column(name = "components")
    private String components;

    @Column(name = "duration")
    private String duration;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "school")
    private String school;

    @ManyToMany(mappedBy = "spells")
    private Set<CharacterEntity> characters = new HashSet<CharacterEntity>();

    public Set<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<CharacterEntity> characters) {
        this.characters = characters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamageType() {
        return damageType;
    }

    public void setDamageType(int damageType) {
        this.damageType = damageType;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
