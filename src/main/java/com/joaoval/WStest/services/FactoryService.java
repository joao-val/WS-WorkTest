package com.joaoval.WStest.services;

import com.joaoval.WStest.dto.FactoryDTO;
import com.joaoval.WStest.entities.Factory;
import com.joaoval.WStest.repositories.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FactoryService {

    @Autowired
    private FactoryRepository repository;

    public Set<FactoryDTO> findAll() {
        List<Factory> result = repository.findAll();
        return (Set<FactoryDTO>) result.stream().map(x -> new FactoryDTO(x)).collect(Collectors.toList());
    }

}
