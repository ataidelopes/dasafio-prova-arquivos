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
public class Sale extends FileModelAbstract<Sale> {

    private String typeId;
    private Integer saleId;
    private List<Itens> itens;
    private String SellerName;


    @Override
    public List<Sale> converterSuperAbstractListTo(final List<FileModelAbstract> fileModelAbstracts) {
        List<Sale> sales = new ArrayList<>();

        for (var model: fileModelAbstracts) {
            Sale sale = new Sale();
            BeanUtils.copyProperties(model, sale);
            sales.add(sale);
        }

        return sales;
    }

    public BigDecimal getValueTotalSale() {
        return itens.stream()
                .map(e -> e.getPrice().multiply(BigDecimal.valueOf(e.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
