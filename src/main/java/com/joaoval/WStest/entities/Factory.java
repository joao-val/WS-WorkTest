package com.joaoval.WStest.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_factory")
public class Factory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String factoryName;
    private String countryCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tb_factory")
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
