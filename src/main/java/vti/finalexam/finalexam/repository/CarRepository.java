package vti.finalexam.finalexam.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import vti.finalexam.finalexam.entity.Car;

@Transactional
public interface CarRepository extends JpaRepository<Car, String>{

    @Query(value = "SELECT * FROM Car WHERE license_plate = :licensePlate AND repair_date = :repairDate", nativeQuery = true)
    Optional<Car> findByLicensePlateAndRepairDate(String licensePlate, String repairDate);

    @Query(value = "DELETE FROM Car WHERE license_plate = :licensePlate AND repair_date = :repairDate", nativeQuery = true)
    void deleteByLicensePlateAndRepairDate(String licensePlate, String repairDate);


}
