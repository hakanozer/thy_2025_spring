package com.works.services;

import com.works.entities.Product;
import com.works.entities.dto.ProductAddDto;
import com.works.entities.dto.ProductUpdateDto;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public Product productAdd(ProductAddDto productAddDto) {
        Product product = modelMapper.map(productAddDto, Product.class);
        return productRepository.save(product);
    }

    public List<Product> productList(){
        return productRepository.findAll();
    }

    public Product productUpdate(ProductUpdateDto productUpdateDto) {
        Optional<Product> optionalProduct = productRepository.findById(productUpdateDto.getPid());
        if (optionalProduct.isPresent()) {
            Product product = modelMapper.map(productUpdateDto, Product.class);
            return productRepository.save(product);
        }
        return null;
    }

}
