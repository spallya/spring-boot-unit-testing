package com.unit.testing.unittestingpractice.repository;

import com.unit.testing.unittestingpractice.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByName() throws Exception {
        Car savedCar = testEntityManager.persistFlushFind(new Car("prius2", "hybrid"));
        assertThat(savedCar.getId()).isNotNull().isNotNegative();
        Car car = repository.findByName("prius2");
        assertThat(car.getName()).isEqualTo("prius2");
        assertThat(car.getType()).isEqualTo("hybrid");
    }
}