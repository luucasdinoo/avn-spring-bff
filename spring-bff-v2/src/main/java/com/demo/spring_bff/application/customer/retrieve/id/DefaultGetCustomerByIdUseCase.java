package com.demo.spring_bff.application.customer.retrieve.id;

import com.demo.spring_bff.application.dto.CustomerData;
import com.demo.spring_bff.domain.exception.EntityNotFoundException;
import com.demo.spring_bff.application.client.CustomerClient;
import feign.FeignException;

import java.util.Objects;

public class DefaultGetCustomerByIdUseCase extends GetCustomerByIdUseCase {

    private final CustomerClient customerClient;

    public DefaultGetCustomerByIdUseCase(final CustomerClient customerClient) {
        this.customerClient = Objects.requireNonNull(customerClient);
    }

    @Override
    public CustomerData execute(final Long id) {
        try {
            return customerClient.getCustomerById(id);

        }catch (FeignException e){
            throw new EntityNotFoundException("Error getting customer by id");
        }
    }
}
