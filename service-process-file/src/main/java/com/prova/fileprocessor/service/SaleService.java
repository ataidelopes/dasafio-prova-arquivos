package com.prova.fileprocessor.service;

import com.prova.fileprocessor.model.Sale;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SaleService {

    public Integer idSalebiggestSale(List<Sale> sales) {
        return  sales.stream()
                .max(Comparator.comparing(Sale::getValueTotalSale))
                .stream().map(Sale::getSaleId)
                .findFirst().get();
    }
}
