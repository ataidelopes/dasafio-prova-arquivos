package com.prova.fileprocessor.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class FileModelAbstract<T> {

    abstract public String getTypeId();

    public DataTypeProcess getDataTypeProcess() {
        return DataTypeProcess.getDataTypeProcessById(getTypeId());
    }

    public abstract List<T> converterSuperAbstractListTo(List<FileModelAbstract> fileModelAbstracts);
}
