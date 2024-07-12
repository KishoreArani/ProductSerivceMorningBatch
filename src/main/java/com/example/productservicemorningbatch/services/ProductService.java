package com.example.productservicemorningbatch.services;

import com.example.productservicemorningbatch.exceptions.InvalidProductIdException;
import com.example.productservicemorningbatch.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws InvalidProductIdException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct();

    Product replaceProduct();

    Void deleteProduct();
}
