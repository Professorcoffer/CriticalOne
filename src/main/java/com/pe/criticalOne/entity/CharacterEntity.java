package com.pe.criticalOne.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "class", nullable = false)
    private String characterClass;

    @Column(name = "background", nullable = false)
    private String background;

    @Column(name = "race", nullable = false)
    private String race;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "outlook", nullable = false)
    private String outlook;

    @Column(name = "experience")
    private int experience;

    @Column(name = "health", nullable = false)
    private int health;

    @Column(name = "armour", nullable = false)
    private int armour;

    @Column(name = "possession")
    private String possession;

    @Column(name = "temper", nullable = false)
    private String temper;

    @Column(name = "ideals", nullable = false)
    private String ideals;

    @Column(name = "affection", nullable = false)
    private String affection;

    @Column(name = "weaknesses", nullable = false)
    private String weaknesses;

    @Column(name = "archetype")
    private String archetype;

    @Column(name = "skills")
    private String skills;

    @Column(name = "gold_coins")
    private int goldCoins;

    @Column(name = "platinum_coins")
    private int platinumCoins;

    @Column(name = "copper_coins")
    private int copperCoins;

    @Column(name = "silver_coins")
    private int silverCoins;

    @Column(name = "strength", nullable = false)
    private int strength;

    @Column(name = "dexterity", nullable = false)
    private int dexterity;

    @Column(name = "constitution", nullable = false)
    private int constitution;

    @Column(name = "intelligence", nullable = false)
    private int intelligence;

    @Column(name = "charisma", nullable = false)
    private int charisma;

    @Column(name = "wisdom", nullable = false)
    private int wisdom;

    @Column(name = "danger", nullable = false)
    private int danger;

    @Column(name = "type", nullable = false)
    private int type;

    @Column(name = "image")
    private String image;

    @ManyToMany
    @JoinTable(name="SpellCell",
            joinColumns = {@JoinColumn(name="characterId")},
            inverseJoinColumns = {@JoinColumn(name="spellId")})
    private Set<SpellEntity> spells = new HashSet<SpellEntity>();
    @ManyToMany
    @JoinTable(name="Cell",
            joinColumns = {@JoinColumn(name="characterId")},
            inverseJoinColumns = {@JoinColumn(name="itemId")})
    private Set<ItemEntity> items = new HashSet<ItemEntity>();

    @ManyToMany
    @JoinTable(name="Characters",
            joinColumns = {@JoinColumn(name="characterId")},
            inverseJoinColumns = {@JoinColumn(name="campaignId")})
    private Set<CampaignEntity> campaigns = new HashSet<CampaignEntity>();

    public CharacterEntity() {
    }
    public Long getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public String getPossession() {
        return possession;
    }

    public void setPossession(String possession) {
        this.possession = possession;
    }

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getAffection() {
        return affection;
    }

    public void setAffection(String affection) {
        this.affection = affection;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public int getPlatinumCoins() {
        return platinumCoins;
    }

    public void setPlatinumCoins(int platinumCoins) {
        this.platinumCoins = platinumCoins;
    }

    public int getCopperCoins() {
        return copperCoins;
    }

    public void setCopperCoins(int copperCoins) {
        this.copperCoins = copperCoins;
    }

    public int getSilverCoins() {
        return silverCoins;
    }

    public void setSilverCoins(int silverCoins) {
        this.silverCoins = silverCoins;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getDanger() {
        return danger;
    }

    public void setDanger(int danger) {
        this.danger = danger;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<SpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(Set<SpellEntity> spells) {
        this.spells = spells;
    }

    public Set<ItemEntity> getItems() {
        return items;
    }

    public void setItems(Set<ItemEntity> items) {
        this.items = items;
    }

    public Set<CampaignEntity> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(Set<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }

    //private String easterEgg="400 строк блять на ебучую анемичную модель, Джава дерьмо ебучее";
    //private String easterEgg2 = "Сверху пидор";
}
