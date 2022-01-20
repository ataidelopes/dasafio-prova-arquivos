package com.prova.fileprocessor.model;

import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer extends FileModelAbstract<Customer> {

    private String typeId;
    private String cnpj;
    private String name;
    private String businessArea;

    @Override
    public List<Customer> converterSuperAbstractListTo(List<FileModelAbstract> fileModelAbstracts) {
        List<Customer> customers = new ArrayList<>();

        for (var model: fileModelAbstracts) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(model, customer);
            customers.add(customer);
        }

        return customers;
    }
}
