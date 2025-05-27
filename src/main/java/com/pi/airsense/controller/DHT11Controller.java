package com.pi.airsense.controller;

import com.pi.airsense.model.DHT11Data;
import com.pi.airsense.model.MQ9Data;
import com.pi.airsense.service.DHT11Service;
import com.pi.airsense.service.MQT9Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/dht11")
public class DHT11Controller {

    @Autowired
    private DHT11Service service;

    @GetMapping
    public ResponseEntity<List<DHT11Data>> listar(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim
    ) {
        List<DHT11Data> dados;

        if (inicio != null && fim != null) {
            dados = service.buscarPorIntervalo(inicio, fim);
        } else {
            dados = service.listarTodos();
        }

        return ResponseEntity.ok(dados);
    }

    @PostMapping
    public ResponseEntity<DHT11Data> salvar(@RequestBody DHT11Data dado) {
        DHT11Data salvo = service.salvar(dado);
        return ResponseEntity.status(201).body(salvo);
    }
}
