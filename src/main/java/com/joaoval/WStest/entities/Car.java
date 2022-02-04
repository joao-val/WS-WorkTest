package com.joaoval.WStest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String model;

    @Column(nullable = false)
    private Short year;

    @Column(nullable = false)
    private String fuel;

    @Column(nullable = false)
    private Short doors;

    @Column(nullable = false)
    private BigDecimal cost;

    @Column(nullable = false)
    private String color;


    @ManyToOne(targetEntity = Factory.class, optional = false)
    @JoinColumn(name = "factory_id", referencedColumnName = "id")
    private Factory factory;

    public Car(){
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

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
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
