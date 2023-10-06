package vti.finalexam.finalexam.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vti.finalexam.finalexam.entity.Car;
import vti.finalexam.finalexam.exception.NotFoundException;
import vti.finalexam.finalexam.services.CarService;

@RestController
@ResponseBody
@RequestMapping("/api/v1/")
public class CarController {

    private final Logger log = LoggerFactory.getLogger(CarController.class);

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Get all Car
    @GetMapping("/cars")
    public List<Car> GetAllCar() {
        log.debug("Request to get all Car");
        return carService.findAll();
    }

    // Get a Car by licensePlate and repairDate
    @GetMapping("/cars/")
    public ResponseEntity<Car> findByLicensePlateAndRepairDate(
            @RequestParam("license_plate") String licensePlate,
            @RequestParam("repair_date") @DateTimeFormat(pattern = "yyyy-MM-dd") String repairDate) {
        log.debug("Request to get Car : {}", licensePlate, repairDate);
        Optional<Car> car = carService.findByLicensePlateAndRepairDate(licensePlate, repairDate);
        return car.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new NotFoundException("Car not found. Check licensePlate and repairDate again"));
    }

    @PostMapping("/cars")
    public Car createCar(
            @RequestParam("license_plate") String licensePlate,
            @RequestParam("repair_date") @DateTimeFormat(pattern = "yyyy-MM-dd") String repairDate,
            @RequestParam("customerName") String customerName,
            @RequestParam(value = "catalogs", required = false) String catalogs,
            @RequestParam(value = "carMaker", required = false) String carMaker) {
        log.debug("Request to save Car : {}", licensePlate);
        try {
            Car car = new Car(licensePlate, repairDate, customerName, catalogs, carMaker);
            return carService.save(car);
        } catch (Exception e) {
            throw new NotFoundException("Failed to save Car");
        }
    }

    // Update a Car
    @PutMapping("/cars")
    public Car UpdateCar(
            @RequestParam("license_plate") String licensePlate,
            @RequestParam("repair_date") @DateTimeFormat(pattern = "yyyy-MM-dd") String repairDate,
            @RequestParam("customerName") String customerName,
            @RequestParam(value = "catalogs", required = false) String catalogs,
            @RequestParam(value = "carMaker", required = false) String carMaker) {
        log.debug("Request to update Car : {}", licensePlate);
        Car car = new Car(licensePlate, repairDate, customerName, catalogs, carMaker);
        return carService.update(car);
    }

    // Delete a Car
    @DeleteMapping("/cars")
    public void deleteCar(
            @RequestParam("license_plate") String licensePlate,
            @RequestParam("repair_date") @DateTimeFormat(pattern = "yyyy-MM-dd") String repairDate) {
        log.debug("Request to delete Car : {}", licensePlate, repairDate);
        try {
            carService.deleteByLicensePlateAndRepairDate(licensePlate, repairDate);
        } catch (Exception e) {
            throw new NotFoundException("Failed to delete Car");
        }
    }


}
