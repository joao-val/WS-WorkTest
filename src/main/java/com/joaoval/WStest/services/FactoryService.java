package com.joaoval.WStest.services;

import com.joaoval.WStest.controllers.forms.FactoryForm;
import com.joaoval.WStest.dto.FactoryDTO;
import com.joaoval.WStest.entities.Factory;
import com.joaoval.WStest.repositories.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class FactoryService {

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    public FactoryService(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    public Factory createFactory(FactoryForm factoryForm){
        Factory factory = new Factory();
        factory.setFactoryName(factoryForm.getFactoryName());
        factory.setCountryCode(factoryForm.getCountryCode());

        factoryRepository.save(factory);

        return factory;
    }

    public Page<Factory> listFactories(Pageable page) {
        return factoryRepository.findAll(page);
    }

    public FactoryDTO findFactory(Long id) {
        Optional<Factory> optional = factoryRepository.findByIdWithCars(id);

        if (optional.isEmpty()){
            throw new EntityNotFoundException(String.format("Factory with id %d not found", id));
        }

        return new FactoryDTO(optional.get());
    }

    @Transactional
    public FactoryDTO changeFactoryData(Long id, FactoryForm factoryForm) {
        Optional<Factory> optional = factoryRepository.findByIdWithCars(id);

        if (optional.isEmpty()){
            throw new EntityNotFoundException(String.format("Factory with id %d not found", id));
        }

        Factory factory = optional.get();

        factory.setFactoryName(factoryForm.getFactoryName());
        factory.setCountryCode(factoryForm.getCountryCode());

        return new FactoryDTO(factory);
    }

    public void deleteFactory(Long id) {
        Optional<Factory> optional = factoryRepository.findById(id);

        if (optional.isEmpty()){
            throw new EntityNotFoundException(String.format("Factory with id %d not found", id));
        }

     factoryRepository.delete(optional.get());
    }
}
