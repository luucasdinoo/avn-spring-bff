package com.demo.spring_bff.application.customer.retrieve.name;

import com.demo.spring_bff.application.dto.CustomerData;
import com.demo.spring_bff.domain.exception.EntityNotFoundException;
import com.demo.spring_bff.application.client.CustomerClient;
import feign.FeignException;

import java.util.Objects;

public class DefaultGetCustomerByNameUseCase extends GetCustomerByNameUseCase {

    private final CustomerClient customerClient;

    public DefaultGetCustomerByNameUseCase(final CustomerClient customerClient) {
        this.customerClient = Objects.requireNonNull(customerClient);
    }

    @Override
    public CustomerData execute(final String name) {
        try {
            return customerClient.getCustomerByName(name);

        }catch (FeignException e){
            throw new EntityNotFoundException("Error getting customer by name");
        }
    }
}
