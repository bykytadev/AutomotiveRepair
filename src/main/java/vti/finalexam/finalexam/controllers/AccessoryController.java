package vti.finalexam.finalexam.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vti.finalexam.finalexam.entity.Accessory;
import vti.finalexam.finalexam.services.AccessoryService;

@RestController
@RequestMapping("/api/v1")
public class AccessoryController {
    private final AccessoryService accessoryService;

    private final Logger log = LoggerFactory.getLogger(AccessoryController.class);

    public AccessoryController(AccessoryService accessoryService) {
        this.accessoryService = accessoryService;
    }

    // Save a Accessory
    @PostMapping("/accessories")
    public Accessory CreateAccessory(
            @RequestParam("name") String name,
            @RequestParam(value = "price", required = false) double price,
            @RequestParam(value = "status damaged", required = false) String statusDamaged,
            @RequestParam(value = "repair status", required = false) String repairStatus) {
        log.debug("Request to save Accessory : {}", name);
        Accessory accessory = new Accessory(name, price, statusDamaged, repairStatus);
        return accessoryService.save(accessory);
    }

    // Update a Accessory
    @PutMapping("/accessories")
    public Accessory UpdateAccessory(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("status damaged") String statusDamaged,
            @RequestParam("repair status") String repairStatus) {
        log.debug("Request to update Accessory : {}", name);
        Accessory accessory = new Accessory(id, name, price, statusDamaged, repairStatus);
        return accessoryService.update(accessory);
    }

    // Update a Accessory by id
    @PutMapping("/accessories/{id}")
    public Optional<Accessory> UpdateAccessoryByID(
            @PathVariable(value = "id") Long id,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("status damaged") String statusDamaged,
            @RequestParam("repair status") String repairStatus) {
        log.debug("Request to update Accessory : {}", name);
        Accessory accessory = new Accessory(id, name, price, statusDamaged, repairStatus);
        return accessoryService.updateById(accessory);
    }

    // Delete a Accessory
    @DeleteMapping("/accessories")
    public void DeleteAccessoryByID(@RequestParam("id") Long id) {
        log.debug("Request to delete Accessory : {}", id);
        accessoryService.delete(id);
    }

    // Get all Accessory
    @GetMapping("/accessories")
    public List<Accessory> GetAllAccessory() {
        log.debug("Request to get all Accessory");
        return accessoryService.findAll();
    }

    // Get a Accessory by id
    @GetMapping("/accessories/{id}")
    public Optional<Accessory> FindAccessoryByID(
        @RequestParam("id") Long id) {
        log.debug("Request to get Accessory : {}", id);
        return accessoryService.findById(id);
    }
}
