package com.demo.spring_bff.infrastructure.api.controller;

import com.demo.spring_bff.application.customer.retrieve.id.GetCustomerByIdUseCase;
import com.demo.spring_bff.application.customer.retrieve.name.GetCustomerByNameUseCase;
import com.demo.spring_bff.application.dto.CustomerData;
import com.demo.spring_bff.infrastructure.api.CustomerAPI;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CustomerController implements CustomerAPI {

    private final GetCustomerByIdUseCase getByIdUseCase;
    private final GetCustomerByNameUseCase getByNameUseCase;

    public CustomerController(final GetCustomerByIdUseCase getByIdUseCase,
                              final GetCustomerByNameUseCase getByNameUseCase) {
        this.getByIdUseCase = Objects.requireNonNull(getByIdUseCase);
        this.getByNameUseCase = Objects.requireNonNull(getByNameUseCase);
    }


    @Override
    public CustomerData getCustomerById(Long id) {
        return getByIdUseCase.execute(id);
    }

    @Override
    public CustomerData getCustomerByName(String name) {
        return getByNameUseCase.execute(name);
    }
}
