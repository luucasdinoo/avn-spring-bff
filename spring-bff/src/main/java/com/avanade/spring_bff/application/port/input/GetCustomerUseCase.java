package com.avanade.spring_bff.application.port.input;

import com.avanade.spring_bff.application.dto.CustomerData;

public interface GetCustomerUseCase {
    CustomerData getCustomerById(long id);

    CustomerData getCustomerByName(String name);
}
