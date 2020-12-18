package br.com.marcatti.kafka.topic.consumer;

import br.com.marcatti.kafka.dto.Dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka.exemplo", groupId = "group_id")
    public void  consumer(String msg) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Dto dto = mapper.readValue(msg, Dto.class);
            log.debug("consumer msg {}", dto.getMsg());
        } catch (JsonProcessingException e) {
            log.error("Problema ao converter objeto {} ", msg);
        }
    }

    @KafkaListener(topics = "kafka.exemplo", groupId = "group_id_2")
    public void  consumer2(String msg) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Dto dto = mapper.readValue(msg, Dto.class);
            log.debug("consumer 2 msg {}", dto.getMsg());
        } catch (JsonProcessingException e) {
            log.error("Problema ao converter objeto {} ", msg);
        }
    }

    @KafkaListener(topics = "kafka.exemplo", groupId = "group_id_3")
    public void  consumer3(String msg) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Dto dto = mapper.readValue(msg, Dto.class);
            log.debug("consumer 3 msg {}", dto.getMsg());
        } catch (JsonProcessingException e) {
            log.error("Problema ao converter objeto {} ", msg);
        }
    }


}
