package com.pi.airsense.controller;

import com.pi.airsense.model.MQ9Data;
import com.pi.airsense.service.MQT9Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/mq9")
public class MQ9Controller {

    @Autowired
    private MQT9Service service;

    @GetMapping
    public ResponseEntity<List<MQ9Data>> listar(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim
    ) {
        List<MQ9Data> dados;

        if (inicio != null && fim != null) {
            dados = service.buscarPorIntervalo(inicio, fim);
        } else {
            dados = service.listarTodos();
        }

        return ResponseEntity.ok(dados);
    }

    @PostMapping
    public ResponseEntity<MQ9Data> salvar(@RequestBody MQ9Data dado) {
        MQ9Data salvo = service.salvar(dado);
        return ResponseEntity.status(201).body(salvo);
    }
}
