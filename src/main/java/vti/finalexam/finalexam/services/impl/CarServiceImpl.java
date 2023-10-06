package vti.finalexam.finalexam.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import vti.finalexam.finalexam.entity.Car;
import vti.finalexam.finalexam.repository.CarRepository;
import vti.finalexam.finalexam.services.CarService;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        log.debug("Request to save Car : {}", car);
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        log.debug("Request to update Car : {}", car);
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> updateByLicensePlate(Car car) {
        log.debug("Request to update Car : {}", car);
        return carRepository.findById(car.getLicensePlate())
                .map(existingCar -> {
                    if (car.getRepairDate() != null) {
                        existingCar.setRepairDate(car.getRepairDate());
                    }
                    return existingCar;
                })
                .map(carRepository::save);
    }

    // deleteByLicensePlateAndRepairDate
    @Override
    public Optional<Car> deleteByLicensePlateAndRepairDate(String licensePlate, String repairDate) {
        log.debug("Request to delete Car : {}", licensePlate);
        return carRepository.findByLicensePlateAndRepairDate(licensePlate, repairDate)
                .map(car -> {
                    carRepository.delete(car);
                    return car;
                });
    }



    @Override
    @Transactional(readOnly = true)
    public List<Car> findAll() {
        log.debug("Request to get all Cars");
        return carRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Car> findByLicensePlateAndRepairDate(String licensePlate, String repairDate) {
        return carRepository.findByLicensePlateAndRepairDate(licensePlate, repairDate);
    }

}
