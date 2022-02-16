package com.joaoval.WStest.repositories;

import com.joaoval.WStest.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT C FROM Car C " +
            "INNER JOIN C.factory F " +
            "WHERE " +
            "(:factoryName is null OR F.factoryName LIKE %:factoryName%) AND " +
            "(C.year BETWEEN :yearMin AND :yearMax) AND " +
            "(C.doors BETWEEN :doorsMin AND :doorsMax) AND " +
            "(C.cost BETWEEN :costMin AND :costMax) AND " +
            "(:color is null OR C.color = :color)" )
    Page<Car> findWithFilters(String factoryName,
                              Short yearMin, Short yearMax,
                              Short doorsMin, Short doorsMax,
                              BigDecimal costMin, BigDecimal costMax,
                              String color,
                              Pageable pageable);
}
