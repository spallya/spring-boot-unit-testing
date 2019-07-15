package com.unit.testing.unittestingpractice.controller;

import com.unit.testing.unittestingpractice.exception.CarNotFoundException;
import com.unit.testing.unittestingpractice.model.Car;
import com.unit.testing.unittestingpractice.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(CarController.class);

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {
        logger.error(ex.getLocalizedMessage());

    }
}
