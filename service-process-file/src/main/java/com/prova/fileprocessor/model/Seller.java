package com.prova.fileprocessor.model;

import lombok.*;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seller extends FileModelAbstract<Seller> {

    private String typeId;
    private String cpf;
    private String name;
    private BigDecimal salary;

    public List<Seller> converterSuperAbstractListTo(final List<FileModelAbstract> fileModelAbstracts) {
        List<Seller> sellers = new ArrayList<>();

        for (var model: fileModelAbstracts) {
            Seller seller = new Seller();
            BeanUtils.copyProperties(model, seller);
            sellers.add(seller);
        }

        return sellers;
    }
}
