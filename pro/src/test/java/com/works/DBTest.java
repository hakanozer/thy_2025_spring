package com.works;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class DBTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @Tag("security")
    void productAddTest(){
        Product product = new Product();
        product.setTitle("Product 2");
        product.setDescription("Product 2 Detail");
        productRepository.save(product);
        Assertions.assertEquals(product.getPid(), 1);
        Assertions.assertEquals(product.getTitle(), "Product 2");
        Assertions.assertEquals(product.getDescription(), "Product 2 Detail");

        List<Product> products = productRepository.findAll();
        System.out.println("products : " + products);
    }

}
