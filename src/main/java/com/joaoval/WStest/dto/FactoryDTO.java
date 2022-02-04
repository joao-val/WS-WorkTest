package com.joaoval.WStest.dto;

import com.joaoval.WStest.entities.Factory;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class FactoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String factoryName;
    private String countryCode;

    private Set<CarDTO> cars;

    public FactoryDTO() {

    }

    public FactoryDTO(Long id, String factoryName, String countryCode, Set<CarDTO> cars){
        this.id = id;
        this.factoryName = factoryName;
        this.countryCode = countryCode;
        this.cars = cars;
    }

    public FactoryDTO(Factory factory) {
        id = factory.getId();
        factoryName = factory.getFactoryName();
        countryCode = factory.getCountryCode();
        cars = new HashSet<>(factory.getCars().stream().map(CarDTO::new).toList());
    }

    public Long getId() {
        return id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Set<CarDTO> getCars() {
        return cars;
    }

}
