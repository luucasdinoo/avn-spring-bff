package com.avanade.spring_bff.application.controller;

import com.avanade.spring_bff.application.dto.CustomerData;
import com.avanade.spring_bff.domain.exception.EntityNotFoundException;
import com.avanade.spring_bff.domain.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.is;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CustomerService customerService;

    @Test
    void givenAValidId_whenCallGetCustomerById_thenReturnCustomer() throws Exception {
        long customerId = 1L;
        CustomerData customerData = new CustomerData(customerId, "John Doe", null, null, null);

        when(customerService.getCustomerById(customerId)).thenReturn(customerData);

        this.mockMvc.perform(get("/bff/customer/{id}", customerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("John Doe")));
    }

    @Test
    void givenAInvalidId_whenCallGetCustomerById_thenReturnException() throws Exception {
        long customerId = 999L;
        when(customerService.getCustomerById(customerId))
                .thenThrow(new EntityNotFoundException("Error getting customer by id"));

        this.mockMvc.perform(get("/bff/customer/{id}", customerId))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Error getting customer by id"));
    }

    @Test
    void givenAValidName_whenCallGetCustomerByName_thenReturnCustomer() throws Exception {
        String customerName = "John Doe";
        CustomerData customerData = new CustomerData(2L, customerName , null, null, null);

        when(customerService.getCustomerByName(customerName)).thenReturn(customerData);

        this.mockMvc.perform(get("/bff/customer/name/{name}", customerName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.name", is("John Doe")));
    }

    @Test
    void givenAInvalidName_whenCallGetCustomerByName_thenReturnException() throws Exception {
        String customerName = "999L";
        when(customerService.getCustomerByName(customerName))
                .thenThrow(new EntityNotFoundException("Error getting customer by name"));

        this.mockMvc.perform(get("/bff/customer/name/{name}", customerName))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Error getting customer by name"));
    }
}
