package com.demo.spring_bff.application.client;

import com.demo.spring_bff.application.dto.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente-service", url = "http://localhost:8080")
public interface CustomerClient {

    @GetMapping("/cliente/{id}")
    CustomerData getCustomerById(@PathVariable Long id);

    @GetMapping("/cliente/name/{customerName}")
    CustomerData getCustomerByName(@PathVariable String customerName);
}
