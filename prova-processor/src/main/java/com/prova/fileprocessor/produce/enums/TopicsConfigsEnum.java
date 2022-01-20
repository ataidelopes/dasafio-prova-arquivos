package com.prova.fileprocessor.produce.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TopicsConfigsEnum {

    TOPIC_FILE("topic-file", 5, Short.valueOf("5"));

    private String topicName;
    private Integer numberPartitions;
    private Short numberReplications;
}
