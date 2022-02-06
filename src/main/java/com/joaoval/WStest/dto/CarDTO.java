package com.joaoval.WStest.dto;

import com.joaoval.WStest.entities.Car;
import com.joaoval.WStest.entities.enums.FuelType;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class CarDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String model;
    private final Short year;
    private final FuelType fuel;
    private final Short doors;
    private final BigDecimal cost;
    private final String color;


    public CarDTO(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.year = car.getYear();
        this.fuel = car.getFuel();
        this.doors = car.getDoors();
        this.cost = car.getCost();
        this.color = car.getColor();
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Short getYear() {
        return year;
    }

    public FuelType getFuel() {
        return fuel;
    }

    public Short getDoors() {
        return doors;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }
}
