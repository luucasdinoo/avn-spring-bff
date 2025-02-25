package com.avanade.spring_bff.application.controller;

import com.avanade.spring_bff.application.dto.CustomerData;
import com.avanade.spring_bff.application.port.input.GetCustomerUseCase;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CustomerController implements CustomerAPI {

    private final GetCustomerUseCase getCustomerUseCase;

    public CustomerController(final GetCustomerUseCase getCustomerUseCase) {
        this.getCustomerUseCase = Objects.requireNonNull(getCustomerUseCase);
    }

    @Override
    public CustomerData getCustomerById(long id) {
        return getCustomerUseCase.getCustomerById(id);
    }

    @Override
    public CustomerData getCustomerByName(String name) {
        return getCustomerUseCase.getCustomerByName(name);
    }
}
