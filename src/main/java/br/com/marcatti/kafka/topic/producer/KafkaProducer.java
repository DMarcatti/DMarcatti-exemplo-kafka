package br.com.marcatti.kafka.topic.producer;

import br.com.marcatti.kafka.dto.Dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "kafka.exemplo";

    public void kafkaSend( Dto dto){
        String msg = null;
        try {
            msg = new ObjectMapper().writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            log.error("Problemas ao converter objeto dto {}", dto );
        }
        kafkaTemplate.send(TOPIC, msg);
    }
}
