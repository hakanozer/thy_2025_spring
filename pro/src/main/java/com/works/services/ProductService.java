package com.works.services;

import com.works.aop.TrackExecution;
import com.works.entities.Product;
import com.works.entities.dto.ProductAddDto;
import com.works.entities.dto.ProductUpdateDto;
import com.works.profiles.IConfig;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Value("${comp.title}")
    private String comp_title;

    private final IConfig iConfig;

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CacheManager cacheManager;

    @TrackExecution("product-add")
    public Product productAdd(ProductAddDto productAddDto) {
        Product product = modelMapper.map(productAddDto, Product.class);
        productRepository.save(product);
        cacheManager.getCache("productList").clear();
        //cacheManager.getCache("productList").put("productList", product);
        return product;
    }

    @Cacheable("productList")
    public List<Product> productList(){
        System.out.println("comp_title: "  + comp_title);
        System.out.println(iConfig.config());
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
