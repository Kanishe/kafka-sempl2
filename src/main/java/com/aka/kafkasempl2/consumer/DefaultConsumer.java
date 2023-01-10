package com.aka.kafkasempl2.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DefaultConsumer {
    @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = "topic4")
    public void listen(@Payload String foo,
                       @Header(KafkaHeaders.RECEIVED_KEY) String k) {
        System.out.println("RECEIVED_KEY:"+ k + "  "+"Payload(MESSAGES):" + foo);
    }
}
