package com.kafka.provider.SpringBootProvider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean // Clase utilizada para crear un topico kafka
    public NewTopic generateTopic() {
        return TopicBuilder.name("unProgramadorNace-Topic")
                .build();
    }
}
