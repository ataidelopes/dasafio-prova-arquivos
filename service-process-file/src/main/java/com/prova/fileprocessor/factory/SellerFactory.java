package com.prova.fileprocessor.factory;

import com.prova.fileprocessor.model.Seller;

import java.math.BigDecimal;

public class SellerFactory implements IFileFactory<Seller> {

    @Override
    public Seller getBuild(String [] lineFile) {
        return Seller.builder()
                .typeId(lineFile[0])
                .cpf(lineFile[1])
                .name(lineFile[2])
                .salary(BigDecimal.valueOf(Double.valueOf(lineFile[3])))
                .build();
    }
}
