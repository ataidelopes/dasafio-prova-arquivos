package com.prova.fileprocessor.factory;

import com.prova.fileprocessor.model.Itens;
import com.prova.fileprocessor.model.Sale;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SaleFactory implements IFileFactory<Sale> {

    @Override
    public Sale getBuild(String[] linefile) {
        return Sale.builder()
                .typeId(linefile[0])
                .saleId(Integer.valueOf(linefile[1]))
                .itens(Itens.converterItensFile(linefile[2]))
                .SellerName(linefile[3])
                .build();
    }
}
