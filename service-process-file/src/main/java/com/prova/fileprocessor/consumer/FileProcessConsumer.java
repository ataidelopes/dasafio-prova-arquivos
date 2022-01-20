package com.prova.fileprocessor.consumer;

import com.prova.fileprocessor.service.ProcessFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class FileProcessConsumer {

    private final ProcessFileService processFileService;

    @KafkaListener(topics = "${file.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumerFileNameToProcess(final ConsumerRecord consumerRecord) {
        log.info("File name to process: {}", consumerRecord.value());

        processFileService.processFile(consumerRecord.value().toString());
    }
}
