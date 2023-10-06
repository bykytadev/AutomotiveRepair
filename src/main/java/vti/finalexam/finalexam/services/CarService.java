package vti.finalexam.finalexam.services;

import java.util.List;
import java.util.Optional;

import vti.finalexam.finalexam.entity.Car;

public interface CarService {

    // Save a Car
    Car save(Car car);

    // Update a Car
    Car update(Car car);

    // Update a Car by license_plate
    Optional<Car> updateByLicensePlate(Car car);

    // Delete a Car
    // void delete(String license_plate, String repair_date);
    Optional<Car> deleteByLicensePlateAndRepairDate(String license_plate, String repair_date);

    // Get all Car
    List<Car> findAll();

    // Get a Car by license_plate and repair_date
    Optional<Car> findByLicensePlateAndRepairDate(String license_plate, String repair_date);
}
