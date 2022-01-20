package com.prova.fileprocessor.factory;

import com.prova.fileprocessor.model.Customer;

public class CustomerFactory implements IFileFactory<Customer> {

    @Override
    public Customer getBuild(String[] linefile) {
        return Customer.builder()
                .typeId(linefile[0])
                .cnpj(linefile[1])
                .name(linefile[2])
                .businessArea(linefile[3])
                .build();
    }
}
