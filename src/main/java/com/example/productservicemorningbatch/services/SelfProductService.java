package com.example.productservicemorningbatch.services;

import com.example.productservicemorningbatch.exceptions.InvalidProductIdException;
import com.example.productservicemorningbatch.models.Category;
import com.example.productservicemorningbatch.models.Product;
import com.example.productservicemorningbatch.repositories.CategoryRepository;
import com.example.productservicemorningbatch.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements  ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        Optional<Product> optionalProdcut = productRepository.findProductById(id);
        if(optionalProdcut.isEmpty()){
            throw new InvalidProductIdException("Invalid ProductId");
        }

        return optionalProdcut.get();
    }

    @Override
    public Product createProduct(Product product) {

        Category category = product.getCategory();

        if(category.getId() == null){
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Void deleteProduct() {
        return null;
    }
}
