package com.joaoval.WStest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_cars")
public class Car implements Serializable {

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

    @Column(nullable = false)
    private String fuel;

    @Column(nullable = false)
    private Short doors;

    @Column(nullable = false)
    private BigDecimal cost;

    @Column(nullable = false)
    private String color;

    public Car(){
    }

    public Car(Factory factory, String model, Short year, String fuel, Short doors, BigDecimal cost, String color) {
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

    public void setId(Long id){
        this.id = id;
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

    public boolean compare(Car oCar) {
         if (oCar.getId() == this.id && oCar.getFactory().getId() == this.factory.getId()) {
             return true;
         } else {
             return false;
         }
    }

}
