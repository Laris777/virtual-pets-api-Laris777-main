package com.wcci.amazon.b4.virtualpet.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "virtual_pets")
public class VirtualPet {
    @Id
    @GeneratedValue    
    private Long id;
    private String petName;
    private String petSpecies;
    private int hunger;
    private int thirst;
    private int boredom;

    public VirtualPet() {

    }

    public VirtualPet(String name, String species, int hunger, int thirst, int boredom) {
        this.petName = name;
        this.petSpecies = species;
        this.hunger = hunger;
        this.thirst = thirst;
        this.boredom = boredom;
    }

    public long getId() {
        return this.id;
    }

    public String getPetName() {
        return this.petName;
    }

    public String getPetSpecies() {
        return this.petSpecies;
    }

    public int getHunger() {
        return this.hunger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public int getBoredom() {
        return this.boredom;
    }

}
