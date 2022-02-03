package com.joaoval.WStest.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_factories")
public class Factory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private String country_code;

    @OneToMany
    private Set<Car> cars;

    public Factory() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public Set<Car> getCars(){
        return cars;
    }

    public void setCars(Set<Car> cars){
        this.cars = cars;
    }

}
