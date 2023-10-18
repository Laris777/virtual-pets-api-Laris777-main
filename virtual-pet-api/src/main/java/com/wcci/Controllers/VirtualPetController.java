package com.wcci.Controllers;

import java.util.*;
import java.util.NoSuchElementException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.wcci.amazon.b4.virtualpet.Repository.VirtualPetRepository;
import com.wcci.amazon.b4.virtualpet.entity.VirtualPet;
import com.wcci.Service.VirtualPetService;
import jakarta.annotation.*;
import org.springframework.ui.Model;


@Controller
public class VirtualPetController {
    private final VirtualPetService petService;

    public VirtualPetController (VirtualPetService petService) {
        this.petService = petService;
    }

    @GetMapping({"", "/", "/home"})
    public String home(Model page) {
        var virtualPets = petService.findAll();
        page.addAttribute("pets", virtualPets);
        return "index.html";
    }

    @PostMapping("/home")
    public String addPet(
        @RequestParam String petName,
        @RequestParam String petSpecies,
        @RequestParam int petHunger,
        @RequestParam int petThirst,
        @RequestParam int petBoredom,
        Model page
    ) {
        if(petName.isBlank() || petSpecies.isBlank() || petHunger == 0 || petThirst == 0 || petBoredom == 0) {
            page.addAttribute("invalidInfo", "Please enter a correct name and species while all numbers must be greater that 0");
            return "errorAddPet.html";
        }
        VirtualPet pet = new VirtualPet(petName, petSpecies, petHunger, petThirst, petBoredom);
        petService.addPet(pet);

        var virtualPets = petService.findAll();
        page.addAttribute("pets", virtualPets);
        return "index.html";
    }

    @PostMapping("/delete")
    public String deletePet(
        @RequestParam Long deleteId,
        Model page
    ) {
        petService.deletePet(deleteId);

        var virtualPets = petService.findAll();
        page.addAttribute("pets", virtualPets);
        return "index.html";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String errorOnDelete(HttpServletRequest request, Exception ex, Model page) {
        String invalidId = request.getParameter("deleteId");
        page.addAttribute("invalidId", invalidId);
        return "errorID.html";
    }

}