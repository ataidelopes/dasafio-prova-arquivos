package com.prova.fileprocessor.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Itens {

    private Integer itemId;
    private Integer quantity;
    private BigDecimal price;

    public static List<Itens> converterItensFile(String itensStr) {
        String[] arrayItens = itensStr.split(",");
        List<Itens> itens = new ArrayList<>();

        for (String str: arrayItens) {

            String[] objItens = str.replace("[", "")
                    .replace("]", "")
                    .split("-");

            var item = Itens.builder()
                .itemId(Integer.valueOf(objItens[0]))
                .quantity(Integer.valueOf(objItens[1]))
                .price(BigDecimal.valueOf(Double.valueOf(objItens[2])))
                .build();

            itens.add(item);
        }

        return itens;
    }
}
