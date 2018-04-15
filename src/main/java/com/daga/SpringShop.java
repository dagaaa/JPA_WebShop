package com.daga;

import com.daga.model.Category;
import com.daga.model.Product;
import com.daga.repository.CategoryRepository;
import com.daga.repository.CustomerRepository;
import com.daga.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@Transactional
@SpringBootApplication
public class SpringShop implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringShop.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {


        Product lalka = new Product();
        lalka.setProductName("Lalka");
        lalka.setProductPrice(10.99);
        Category zabawki = new Category();
        zabawki.setName("zabawki");
        lalka.setCategory(zabawki);

        lalka.setUnitsOnStock(10);


        Product sukienka = new Product();
        sukienka.setProductName("Sukienka");
        sukienka.setProductPrice(50.0);
        sukienka.setUnitsOnStock(20);
        Category ubrania = new Category();
        ubrania.setName("ubrania");
        sukienka.setCategory(ubrania);

        Product spodnie = new Product();
        spodnie.setProductName("Spodnie");
        spodnie.setProductPrice(70.0);
        spodnie.setUnitsOnStock(5);
        spodnie.setCategory(ubrania);

        categoryRepository.save(ubrania);
        categoryRepository.save(zabawki);

        productRepository.save(sukienka);
        productRepository.save(spodnie);
        productRepository.save(lalka);
//        Product mocha = new Product();
//        mocha.setProductName("Mocha");
//        mocha.setProductPrice(3.95);
//
//        Product capuccinno = new Product();
//        capuccinno.setProductName("Capuccinno");
//        capuccinno.setProductPrice(4.95);
//
//        productRepository.save(mocha);
//        productRepository.save(capuccinno);


    }


}
