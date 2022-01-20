package com.prova.fileprocessor.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileOut {

    //total de vendedores
    private Integer amountSellers;
    // total de clientes
    private Integer amountCustomers;

    // venda mais cara
    private Integer expensiveSaleId;

    // pior vendedor
    private String worstSellers;

    @Override
    public String toString() {
        return "{" +
                "amountSellers=" + amountSellers +
                ", amountCustomers=" + amountCustomers +
                ", expensiveSaleId=" + expensiveSaleId +
                ", worstSellers='" + worstSellers + '\'' +
                '}';
    }
}
