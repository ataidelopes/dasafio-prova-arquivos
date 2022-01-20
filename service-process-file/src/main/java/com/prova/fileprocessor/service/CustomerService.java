package com.prova.fileprocessor.service;

import com.prova.fileprocessor.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * classe para representar os servicos
 * */
@Service
public class CustomerService {

    public Integer amountCustomerInFile(List<Customer> customers) {
        return customers.size();
    }


}
