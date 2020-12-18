package br.com.marcatti.kafka.service;

import br.com.marcatti.kafka.dto.Dto;
import br.com.marcatti.kafka.topic.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceKafka {

    @Autowired
    KafkaProducer kafkaProducer;

    public void send( Dto dto){
        kafkaProducer.kafkaSend(dto);
    }
}
