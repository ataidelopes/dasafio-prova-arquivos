package com.prova.fileprocessor.service;

import com.prova.fileprocessor.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProcessOutFile {

    private final SellerService sellerService;
    private final CustomerService customerService;
    private final SaleService saleService;

    public FileOut processInformationFile(Map<DataTypeProcess, List<FileModelAbstract>> mapInforFile) {
        List<Seller> sellers = new Seller().converterSuperAbstractListTo(mapInforFile.get(DataTypeProcess.TYPE_SELLER));
        List<Customer> customers = new Customer().converterSuperAbstractListTo(mapInforFile.get(DataTypeProcess.TYPE_SELLER));
        List<Sale> sales = new Sale().converterSuperAbstractListTo(mapInforFile.get(DataTypeProcess.TYPE_SALES));

        final Integer amountSellerInFile = sellerService.amountSellerInFile(sellers);
        final Integer amountCustomerInFile = customerService.amountCustomerInFile(customers);
        final Integer biggestSale = saleService.idSalebiggestSale(sales);
        final String worstSellers = sellerService.worstSeller(sales);

        return FileOut.builder()
                .amountCustomers(amountCustomerInFile)
                .amountSellers(amountSellerInFile)
                .expensiveSaleId(biggestSale)
                .worstSellers(worstSellers)
                .build();
    }

}
