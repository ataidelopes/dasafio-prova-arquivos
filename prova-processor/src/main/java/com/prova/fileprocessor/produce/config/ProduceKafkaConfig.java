package com.prova.fileprocessor.produce.config;

import com.prova.fileprocessor.produce.enums.TopicsConfigsEnum;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

//@Configuration
@RequiredArgsConstructor
public class ProduceKafkaConfig {

    private final KafkaProperties kafkaProperties;

//    @Bean
    public ProducerFactory<String, String> producerFactory(){
        final var configs = new HashMap<String, Object>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_DOC, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(configs);
    }

//    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        final var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    /**
     * Metodo para criar o topico, sem a necessidade do administrador criar manualmente
     * PS: em producao criar manualmente (boas praticas)
     * @return novo topico chamado topic-file com 5 particoes e somente um brocker
     * (importante se houver mais que uma replicacao [Resiliencia])
     */
    @Bean
    public NewTopic createTopicFile() {
        final var topicFile = TopicsConfigsEnum.TOPIC_FILE;
        return new NewTopic(topicFile.getTopicName(), topicFile.getNumberPartitions(), topicFile.getNumberReplications());
    }
}
