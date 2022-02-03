package com.joaoval.WStest.repositories;

import com.joaoval.WStest.entities.Car;
import com.joaoval.WStest.entities.Factory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
