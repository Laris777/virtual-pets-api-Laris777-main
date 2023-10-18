package com.wcci.amazon.b4.virtualpet;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.*;

import com.wcci.ProjectConfig;
import com.wcci.amazon.b4.virtualpet.Repository.VirtualPetRepository;
import com.wcci.amazon.b4.virtualpet.entity.VirtualPet;

import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class VirtualPetApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ProjectConfig.class).web(WebApplicationType.SERVLET).run(args);
	}

	@Bean
	CommandLineRunner CommandLineRunner(VirtualPetRepository petRepo) {
		return arg -> {
			VirtualPet Whiskers = new VirtualPet("Whiskers", "Cat", 1, 1, 1);
			petRepo.save(Whiskers);
			VirtualPet Sadie = new VirtualPet("Sadie", "Cat", 1, 1, 1);
			petRepo.save(Sadie);
			VirtualPet Cujo = new VirtualPet("Cujo", "Dog", 1, 1, 1);
			petRepo.save(Cujo);
			VirtualPet Spot = new VirtualPet("Spot", "Dog", 1, 1, 1);
			petRepo.save(Spot);
			VirtualPet Chester = new VirtualPet("Chester", "Robot Cat", 1, 1, 1);
			petRepo.save(Chester);
			VirtualPet Beethoven = new VirtualPet("Beethoven", "Robot Dog", 1, 1, 1);
			petRepo.save(Beethoven);
		};
	}
}
