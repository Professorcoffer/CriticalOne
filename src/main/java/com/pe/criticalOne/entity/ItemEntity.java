package com.pe.criticalOne.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "rarity", nullable = false)
    private int rarity;

    @Column(name = "tunable")
    private Boolean tunable;

    @Column(name = "cost")
    private int cost;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "type", nullable = false)
    private int type;

    @ManyToMany(mappedBy = "items")
    private Set<CharacterEntity> characters = new HashSet<CharacterEntity>();

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

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public Boolean getTunable() {
        return tunable;
    }

    public void setTunable(Boolean tunable) {
        this.tunable = tunable;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Set<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<CharacterEntity> characters) {
        this.characters = characters;
    }
}
