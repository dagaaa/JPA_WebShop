package com.daga.repository;


import com.daga.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findProductsByCategoryName(String name);

    Product findProductByProductID(Integer id);
}




