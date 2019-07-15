package com.unit.testing.unittestingpractice.repository;

import com.unit.testing.unittestingpractice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    public Car findByName(String name);
}
