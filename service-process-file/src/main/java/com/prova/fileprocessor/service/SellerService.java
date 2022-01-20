package com.prova.fileprocessor.service;

import com.prova.fileprocessor.model.Sale;
import com.prova.fileprocessor.model.Seller;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SellerService {

    public Integer amountSellerInFile(List<Seller> sellers) {
        return sellers.size();
    }

    public String worstSeller(List<Sale> sales) {

        return sales.stream()
                .min(Comparator.comparing(Sale::getValueTotalSale))
                .map(Sale::getSellerName)
                .get();
    }
}
