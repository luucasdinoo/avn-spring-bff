package com.avanade.spring_bff.application.controller;

import com.avanade.spring_bff.application.dto.CustomerData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("bff/customer")
public interface CustomerAPI {

    @GetMapping("{id}")
    CustomerData getCustomerById(@PathVariable long id);

    @GetMapping("name/{name}")
    CustomerData getCustomerByName(@PathVariable String name);
}
