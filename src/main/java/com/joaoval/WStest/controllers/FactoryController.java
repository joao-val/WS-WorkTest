package com.joaoval.WStest.controllers;

import com.joaoval.WStest.controllers.forms.FactoryForm;
import com.joaoval.WStest.dto.FactoryDTO;
import com.joaoval.WStest.entities.Factory;
import com.joaoval.WStest.services.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/factory")
public class FactoryController {

    @Autowired
    private final FactoryService factoryService;

    @Autowired
    public FactoryController(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GetMapping
    public ResponseEntity<Page<Factory>> listFactories(
            @PageableDefault(sort = "id")Pageable page){
        Page<Factory> factories = factoryService.listFactories(page);

        return ResponseEntity.ok(factories);
    }

    @GetMapping("{id}")
    public ResponseEntity<FactoryDTO> findFactoryById(@PathVariable("id") Long id){
        FactoryDTO factoryDTO = factoryService.findFactory(id);
        return ResponseEntity.ok(factoryDTO);
    }

    @PostMapping
    public ResponseEntity<Factory> addFactoryToDB(@RequestBody @Valid FactoryForm factoryForm, UriComponentsBuilder builder){

        Factory factory = factoryService.createFactory(factoryForm);

        URI uri = builder.path("/factory/{id}").buildAndExpand(factory.getId()).toUri();

        return ResponseEntity.created(uri).body(factory);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<FactoryDTO> changeFactoryData(
            @PathVariable("id") Long id,
            @RequestBody @Valid FactoryForm factoryForm
    ){
        FactoryDTO factoryDTO = factoryService.updateFactoryData(id, factoryForm);

        return ResponseEntity.ok(factoryDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFactoryFromDB(@PathVariable("id") Long id){
        factoryService.deleteFactory(id);
        return ResponseEntity.noContent().build();
    }
}
