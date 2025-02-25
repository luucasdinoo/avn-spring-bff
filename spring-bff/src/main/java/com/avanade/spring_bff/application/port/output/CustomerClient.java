package com.avanade.spring_bff.application.port.output;

import com.avanade.spring_bff.application.dto.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente-service", url = "http://localhost:8080")
public interface CustomerClient {

    @GetMapping("/cliente/{id}")
    CustomerData getUserById(@PathVariable Long id);

    @GetMapping("/cliente/name/{customerName}")
    CustomerData getUserByName(@PathVariable String customerName);
}
