package com.unit.testing.unittestingpractice.service;

import com.unit.testing.unittestingpractice.exception.CarNotFoundException;
import com.unit.testing.unittestingpractice.model.Car;
import com.unit.testing.unittestingpractice.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {


    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);
        if (null == car)
            throw new CarNotFoundException();
        return car;
    }
}
