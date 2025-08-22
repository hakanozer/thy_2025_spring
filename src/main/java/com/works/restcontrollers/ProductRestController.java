package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.entities.dto.ProductAddDto;
import com.works.entities.dto.ProductUpdateDto;
import com.works.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("add")
    public Product add(@Valid @RequestBody ProductAddDto productAddDto) {
        return productService.productAdd(productAddDto);
    }

    @GetMapping("list")
    public List<Product> productList(){
        return productService.productList();
    }

    @PutMapping("update")
    public ResponseEntity<Object> update(@Valid @RequestBody ProductUpdateDto productUpdateDto) {
        Product product = productService.productUpdate(productUpdateDto);
        if (product != null) {
            return ResponseEntity.ok().body(product);
        }
        return new ResponseEntity<>(productUpdateDto, HttpStatus.NOT_FOUND);
    }

}
