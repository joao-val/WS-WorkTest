package com.joaoval.WStest.controllers;

import com.joaoval.WStest.dto.FactoryDTO;
import com.joaoval.WStest.services.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/factories")
public class FactoryController {

    @Autowired
    private FactoryService factoryService;

    @GetMapping
    public ResponseEntity<Set<FactoryDTO>> findAll() {
        Set<FactoryDTO> list = factoryService.findAll();
        return ResponseEntity.ok(list);
    }
}
