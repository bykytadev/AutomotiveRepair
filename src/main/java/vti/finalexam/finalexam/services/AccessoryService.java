package vti.finalexam.finalexam.services;

import java.util.List;
import java.util.Optional;

import vti.finalexam.finalexam.entity.Accessory;


public interface AccessoryService {

    // Save a Accessory
    Accessory save(Accessory accessory);

    // Update a Accessory
    Accessory update(Accessory accessory);

    // Update a Accessory by id
    Optional<Accessory> updateById(Accessory accessory);

    // Delete a Accessory   
    void delete(Long id);

    // Get all Accessory
    List<Accessory> findAll();

    // Get a Accessory by id
    Optional<Accessory> findById(Long id);
    
}
