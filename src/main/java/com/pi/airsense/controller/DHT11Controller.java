package com.pi.airsense.controller;

import com.pi.airsense.model.DHT11Data;
import com.pi.airsense.service.DHT11Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dht11")
public class DHT11Controller {

    @Autowired
    private DHT11Service service;

    @GetMapping
    public List<DHT11Data> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public DHT11Data salvar(@RequestBody DHT11Data dado) {
        return service.salvar(dado);
    }
}
