package com.prova.fileprocessor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum DataTypeProcess {

    TYPE_SELLER("001", "Cliente"),
    TYPE_CUSTOMER("002", "Vendedores"),
    TYPE_SALES("003", "Vendas");

    private final String idType;
    private final String descType;

    public static DataTypeProcess getDataTypeProcessById(String typeId){
        return Stream.of(values())
                .filter(type -> type.getIdType().equals(typeId))
                .findAny().orElse(null);
    }
}
