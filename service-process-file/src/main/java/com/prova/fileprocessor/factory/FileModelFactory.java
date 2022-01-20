package com.prova.fileprocessor.factory;

import com.prova.fileprocessor.model.*;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class FileModelFactory {

    private static final Map<DataTypeProcess, IFileFactory> fileFactoryMap =
            Map.of(DataTypeProcess.TYPE_CUSTOMER, new CustomerFactory(),
                    DataTypeProcess.TYPE_SALES, new SaleFactory(),
                    DataTypeProcess.TYPE_SELLER, new SellerFactory());

    public static FileModelAbstract getFileModelAbstract(String[] str, DataTypeProcess processById) {
        if(DataTypeProcess.TYPE_CUSTOMER.equals(processById)){
            return (Customer) fileFactoryMap.get(processById).getBuild(str);
        }
        if(DataTypeProcess.TYPE_SELLER.equals(processById)){
            return (Seller) fileFactoryMap.get(processById).getBuild(str);
        }
        if( DataTypeProcess.TYPE_SALES.equals(processById)){
            return (Sale) fileFactoryMap.get(processById).getBuild(str);
        }
        return null;
    }
}
