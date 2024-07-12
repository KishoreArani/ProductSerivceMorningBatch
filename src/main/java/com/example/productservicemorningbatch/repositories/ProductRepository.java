package com.example.productservicemorningbatch.repositories;

import com.example.productservicemorningbatch.models.Category;
import com.example.productservicemorningbatch.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();

    Optional<Product> findProductById(Long id);
    Optional<Product> findProductByCategory(Category category);
    Optional<Product> findProductByImage(String image);

    List<Product> findByTitleContaining(String word);

    List<Product> findTopThreeByTitle(String title);
    void deleteById(Long id);
    void deleteByTitle(String title);

    Product save(Product product);

}
