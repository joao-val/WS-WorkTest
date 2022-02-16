package com.joaoval.WStest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tb_factory")
public class Factory implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( unique = true)
    private String factoryName;

    private String countryCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    @JsonBackReference
    private Set<Car> cars;

    public Factory() {
    }

    public Long getId() {
        return id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Set<Car> getCars(){
        return cars;
    }

    public void setCars(Set<Car> cars){
        this.cars = cars;
    }

}
