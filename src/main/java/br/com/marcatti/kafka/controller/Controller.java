package br.com.marcatti.kafka.controller;

import br.com.marcatti.kafka.dto.Dto;
import br.com.marcatti.kafka.service.ServiceKafka;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    ServiceKafka service;

    @PostMapping
    public ResponseEntity<String> sendToKafka(@RequestBody Dto dto){
        log.debug("sendToKafka Dto {}" , dto);
        service.send(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }}
