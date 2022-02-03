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
    private String name;
    private String country_code;

    private Set<CarDTO> cars;

    public FactoryDTO() {

    }

    public FactoryDTO(Long id, String name, String country_code, Set<CarDTO> cars){
        this.id = id;
        this.name = name;
        this.country_code = country_code;
        this.cars = cars;
    }

    public FactoryDTO(Factory factory) {
        id = factory.getId();
        name = factory.getName();
        country_code = factory.getCountry_code();
        cars = new HashSet<>(factory.getCars().stream().map(CarDTO::new).toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public Set<CarDTO> getCars() {
        return cars;
    }

}
