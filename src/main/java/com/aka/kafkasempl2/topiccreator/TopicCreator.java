package com.aka.kafkasempl2.topiccreator;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicCreator {

    @Value("${spring.kafka.bootstrap-servers}")
    public String bootstrap;

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrap);
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic newTopic1(){
        return TopicBuilder.name("thig1")
                .partitions(10)
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG,"gzip")
                .build();
    }

    @Bean
    public NewTopic newTopic2(){
        return TopicBuilder.name("thig2")
                .partitions(10)
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG,"gzip")
                .build();
    }
}
