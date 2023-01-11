package com.aka.kafkasempl2.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultConsumer {
    @Value("${spring.kafka.template.default-topic}")
     private static final String TOPIC_NAME = "topic4";


    @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = TOPIC_NAME)
    public void listen(@Payload String foo,
                       @Header(KafkaHeaders.RECEIVED_KEY) String k) {
        System.out.println("RECEIVED_KEY:"+ k + "  "+"Payload(MESSAGES):" + foo);
        log.info(k.toLowerCase()+ foo.toLowerCase());
    }
}
