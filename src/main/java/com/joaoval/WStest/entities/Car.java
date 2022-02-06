package com.joaoval.WStest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.joaoval.WStest.entities.enums.FuelType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Factory.class, optional = false)
    @JoinColumn(name = "factory_id", referencedColumnName = "id")
    @JsonManagedReference
    private Factory factory;

    @Column(nullable = false, length = 30)
    private String model;

    @Column(nullable = false)
    private Short year;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FuelType fuel;

    @Column(nullable = false)
    private Short doors;

    @Column(nullable = false)
    private BigDecimal cost;

    @Column(nullable = false)
    private String color;

    public Car(){
    }

    public Car(Factory factory, String model, Short year, FuelType fuel, Short doors, BigDecimal cost, String color) {
        this.factory = factory;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.doors = doors;
        this.cost = cost;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public FuelType getFuel() {
        return fuel;
    }

    public void setFuel(FuelType fuel) {
        this.fuel = fuel;
    }

    public Short getDoors() {
        return doors;
    }

    public void setDoors(Short doors) {
        this.doors = doors;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
