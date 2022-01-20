package com.prova.fileprocessor.produce;

import com.prova.fileprocessor.produce.enums.TopicsConfigsEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProduce {

    @Value("${file.topic.name}")
    private String fileTopicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageFileForRead(final String fileName) {
        final var key = UUID.randomUUID().toString();
        final var nameTopic = TopicsConfigsEnum.TOPIC_FILE.getTopicName();
        log.info("send message to topic  '{}' to process the file: '{}' ", nameTopic, fileName);
        kafkaTemplate.send(fileTopicName, key, fileName);
    }

}
