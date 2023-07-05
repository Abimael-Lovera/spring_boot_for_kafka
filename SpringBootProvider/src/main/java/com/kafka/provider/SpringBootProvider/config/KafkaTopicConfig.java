package com.kafka.provider.SpringBootProvider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Bean // Clase utilizada para crear un topico kafka
    public NewTopic generateTopic() {

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete(siempre borra el mensaje), compact(mantiene el mas atual)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "864000000"); // tiempo de rentecion de mensajes, por defecto = -1 /->nunca se borran
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");// tamaño maximo del segmento 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // tamaño maximo de cada mensaje - defecto 1MB


        return TopicBuilder.name("unProgramadorNace-Topic")
                .partitions(2)
                .replicas(2) // hablitar redundancia do topico
                .configs(configurations)
                .build();
    }
}
