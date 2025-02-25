package com.avanade.spring_bff.domain.service;

import com.avanade.spring_bff.application.dto.CustomerData;
import com.avanade.spring_bff.application.port.input.GetCustomerUseCase;
import com.avanade.spring_bff.domain.exception.EntityNotFoundException;
import com.avanade.spring_bff.application.port.output.CustomerClient;
import feign.FeignException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerService implements GetCustomerUseCase {

    private final CustomerClient customerClient;

    public CustomerService(final CustomerClient customerClient) {
        this.customerClient = Objects.requireNonNull(customerClient);
    }

    @Override
    public CustomerData getCustomerById(long id) {
        try {
            return customerClient.getUserById(id);
        } catch (FeignException e) {
            throw new EntityNotFoundException("Error getting customer by id");
        }
    }

    @Override
    public CustomerData getCustomerByName(String name) {
        try {
            return customerClient.getUserByName(name);
        } catch (FeignException e) {
            throw new EntityNotFoundException("Error getting customer by name");
        }
    }
}
