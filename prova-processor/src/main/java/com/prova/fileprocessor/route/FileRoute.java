package com.prova.fileprocessor.route;

import org.apache.camel.LoggingLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class FileRoute extends RouteBuilderSupport {


    private static final String HEADER_NAME_FILE = "HEADER_NAME_FILE";

    @Value("${file.path}/in/")
    private String path_file_input;

    @Value("${file.path}/read/")
    private String path_file_read;

    @Value("${file.enable.file.route}")
    private Boolean enableFile = true;

    @Override
    protected void configureRoute() {
        final var timeReadFile = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        final var fileName = getNameFile(timeReadFile);

        from(getEndpointName(fileName))
                .log(LoggingLevel.INFO, "consumindo o arquivo: " + fileName)
                .setHeader(HEADER_NAME_FILE, constant(timeReadFile))
                .autoStartup(enableFile)
                .process("fileProcessor");

    }


    private String getEndpointName(String fileName) {
        return "file://" + path_file_input + getCamelOptions(fileName);
    }

    private String getCamelOptions(String fileName) {
        return "?includeExt=dat&move="+ path_file_read +
                fileName +
                "&moveFailed=.erros/"+
                fileName +
                "&readLock=rename&initialDelay=1000&delay=1000";
    }

    /**
     * metodo para adicionar um nome unico ao arquivo que sera processado
     * pelo servico de consumer
     *
     * @param timeFormatName string para adicionar o timestamp que o arquivo esta sendo processado
     * @return nome completo do arquivo
     */
    private static String getNameFile(String timeFormatName){
        return "${file:onlyname.noext}-" +
                timeFormatName +
                ".${file:ext}";
    }
}
