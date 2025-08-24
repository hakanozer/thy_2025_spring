package com.works;

import com.works.entities.Product;
import com.works.entities.dto.ProductAddDto;
import com.works.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void productAdd() {
        ProductAddDto productAddDto = new ProductAddDto("Product-1","Product-1 Detail",10.0);
        Product product = productService.productAdd(productAddDto);
        Assertions.assertNotNull(product);
        Assertions.assertEquals(product.getTitle(), "Product-1");
        System.out.println(product.getPid());
    }

}
