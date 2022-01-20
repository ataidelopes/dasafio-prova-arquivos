package com.prova.fileprocessor.processor;

import com.prova.fileprocessor.produce.KafkaProduce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class FileProcessor implements Processor {

    public static final String CAMEL_FILE_NAME = "CamelFileName";
    private final KafkaProduce kafkaProduce;


    @Override
    public void process(Exchange exchange) {
        final var nameFileToProcess = getNameFileToProcess(exchange);
        if(StringUtils.hasText(nameFileToProcess)) {
            kafkaProduce.sendMessageFileForRead(nameFileToProcess);
        }
    }

    /**
     * metodo para retornar o nome do arquivo que sera processado e enviado
     * pela mensageria
     *
     * @param exchange exchange do process
     * @return nome completo do arquivo que sera processado
     */
    private String getNameFileToProcess(Exchange exchange) {

        return Optional.ofNullable(exchange.getIn().getHeader(CAMEL_FILE_NAME))
                .map(name -> StringUtils.stripFilenameExtension(name.toString()) + "-" +
                        exchange.getIn().getHeader("HEADER_NAME_FILE") +
                        "." + StringUtils.getFilenameExtension(name.toString())
                ).orElse(null);
    }
}
