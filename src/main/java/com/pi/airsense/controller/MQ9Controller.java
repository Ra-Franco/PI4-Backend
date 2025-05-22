package com.pi.airsense.controller;

import com.pi.airsense.model.MQ9Data;
import com.pi.airsense.service.MQT9Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mq9")
public class MQ9Controller {
    @Autowired
    private MQT9Service service;

    @GetMapping
    public List<MQ9Data> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public MQ9Data salvar(@RequestBody MQ9Data dado) {
        return service.salvar(dado);
    }
}
