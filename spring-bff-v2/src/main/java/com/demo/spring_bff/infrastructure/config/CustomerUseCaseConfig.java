package com.demo.spring_bff.infrastructure.config;

import com.demo.spring_bff.application.customer.retrieve.id.DefaultGetCustomerByIdUseCase;
import com.demo.spring_bff.application.customer.retrieve.id.GetCustomerByIdUseCase;
import com.demo.spring_bff.application.customer.retrieve.name.DefaultGetCustomerByNameUseCase;
import com.demo.spring_bff.application.customer.retrieve.name.GetCustomerByNameUseCase;
import com.demo.spring_bff.application.client.CustomerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class CustomerUseCaseConfig {

    private final CustomerClient customerClient;

    public CustomerUseCaseConfig(final CustomerClient customerClient) {
        this.customerClient = Objects.requireNonNull(customerClient);
    }

    @Bean
    public GetCustomerByIdUseCase getCustomerByIdUseCase(){
        return new DefaultGetCustomerByIdUseCase(customerClient);
    }

    @Bean
    public GetCustomerByNameUseCase getCustomerByNameUseCase(){
        return new DefaultGetCustomerByNameUseCase(customerClient);
    }
}
