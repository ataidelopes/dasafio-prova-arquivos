package com.prova.fileprocessor.service;

import com.prova.fileprocessor.factory.FileModelFactory;
import com.prova.fileprocessor.model.DataTypeProcess;
import com.prova.fileprocessor.model.FileModelAbstract;
import com.prova.fileprocessor.model.FileOut;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProcessFileService {

    private final ProcessOutFile processOutFile;

    @Value("${file.path}/read/")
    private String pathReady;

    @Value("${file.path}/out/")
    private String pathOut;

    public void processFile(String nameFile) {
        try(Stream<String> stream = Files.lines(Paths.get(pathReady.concat(nameFile)))) {
            Map<DataTypeProcess, List<FileModelAbstract>> mapObjectToProcesso = new HashMap<>();
            stream.forEach(values -> createMapObjectProcess(values.split(";"), mapObjectToProcesso));

            FileOut fileOut = processOutFile.processInformationFile(mapObjectToProcesso);
            writeFileOut(fileOut, nameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFileOut(FileOut fileOut, String nameFile) {
        byte[] bytes = fileOut.toString().getBytes();
        try (OutputStream out = new FileOutputStream(getFile(nameFile))) {
            out.write(bytes);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private File getFile(String nameFile){
        final String path = pathOut.concat(getNameOutFileDone(nameFile));
        File file = Paths.get(path).toFile();

        return file.exists() ? file : new File(path);
    }

    private String getNameOutFileDone(String nameFile){
        int idx = nameFile.indexOf("-");
        return nameFile.substring(0, idx + 1).concat("done.").concat(StringUtils.getFilenameExtension(nameFile));
    }

    private void createMapObjectProcess(String[] str, Map<DataTypeProcess, List<FileModelAbstract>> map) {
        DataTypeProcess processById = DataTypeProcess.getDataTypeProcessById(str[0]);
        map.computeIfAbsent(processById, k -> new ArrayList<>()).add(FileModelFactory.getFileModelAbstract(str, processById));
    }


}
