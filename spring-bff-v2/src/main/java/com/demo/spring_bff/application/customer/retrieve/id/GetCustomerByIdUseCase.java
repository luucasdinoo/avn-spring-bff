package com.demo.spring_bff.application.customer.retrieve.id;

import com.demo.spring_bff.application.UseCase;
import com.demo.spring_bff.application.dto.CustomerData;

public abstract class GetCustomerByIdUseCase
        extends UseCase<Long, CustomerData> {
}
