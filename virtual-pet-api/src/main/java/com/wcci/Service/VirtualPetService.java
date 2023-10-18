package com.wcci.Service;

import org.springframework.stereotype.Service;
import com.wcci.amazon.b4.virtualpet.Repository.VirtualPetRepository;
import com.wcci.amazon.b4.virtualpet.entity.VirtualPet;

@Service
public class VirtualPetService {
    private VirtualPetRepository petRepo;

    public VirtualPetService (VirtualPetRepository petRepo) {
        this.petRepo = petRepo;
    }

    public Iterable<VirtualPet> findAll() {
        return petRepo.findAll();
    }
    
    public void addPet(VirtualPet pet) {
        petRepo.save(pet);
    }

    public void deletePet(Long id) {
        petRepo.findById(id).get();
        petRepo.deleteById(id);
    }
}
