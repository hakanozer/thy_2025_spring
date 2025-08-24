package com.works.restcontrollers;

import com.works.entities.Customer;
import com.works.entities.Product;
import com.works.projections.CustomerAddress;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerRestController {

    private final CustomerRepository customerRepository;

    @GetMapping("list")
    public List<Customer> productList(){
        return customerRepository.findByAddresses_AidEquals(3l);
    }


}
