package com.joaoval.WStest.controllers.forms;

import com.joaoval.WStest.entities.enums.FuelType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CarForm {

    @NotBlank(message = "A valid model is required")
    private String model;

    @Length(min = 1890, max = 2050, message = "The year must be between {min}-{max}")
    @NotNull(message = "A valid year is required")
    private Short year;

    @NotNull(message = "A valid fuelType is required")
    private FuelType fuelType;

    @Length(min = 1, max = 4, message = "The doors number must be between {min}-{max}")
    @NotNull(message = "A valid number os doors is required")
    private Short doors;

    @NotNull(message = "Cost must not be null")
    @Min(value = 0, message = "Must be a positive value")
    private BigDecimal cost;

    @NotBlank(message = "A valid color is required")
    private String color;

    @NotNull(message = "A valid factoryId is required")
    @Min(value = 0, message = "Must be a positive value")
    private Long factoryId;

    public CarForm() {
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

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
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

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }
}
