package com.joaoval.WStest.repositories;

import com.joaoval.WStest.entities.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Long> {


    @Query(value = "SELECT F FROM Factory F" +
            "WHERE F.id = :id")
    Optional<Factory> findByIdWithCars(@Param("id") Long id);

    Optional<Factory> findByFactoryName(String name);

}
