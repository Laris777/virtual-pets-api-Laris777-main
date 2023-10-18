package com.wcci.amazon.b4.virtualpet.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wcci.amazon.b4.virtualpet.entity.VirtualPet;

@Repository 
public interface VirtualPetRepository extends CrudRepository<VirtualPet, Long> {

}