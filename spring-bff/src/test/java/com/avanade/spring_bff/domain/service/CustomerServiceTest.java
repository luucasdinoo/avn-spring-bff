package com.avanade.spring_bff.domain.service;

import com.avanade.spring_bff.application.dto.CustomerData;
import com.avanade.spring_bff.domain.exception.EntityNotFoundException;
import com.avanade.spring_bff.application.port.output.CustomerClient;
import static org.junit.jupiter.api.Assertions.*;

import feign.FeignException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerClient customerClient;

    @Test
    void givenAValidId_whenGetCustomerById_thenReturnCustomer(){
        long expectedId = 1L;
        String expectedName = "John Doe";
        String expectedSegmentName = "segmentName";
        CustomerData customerData = new CustomerData(expectedId, expectedName, expectedSegmentName, null, null);

        when(customerClient.getUserById(eq(expectedId)))
                .thenReturn(customerData);

        CustomerData actualCustomerData = customerService.getCustomerById(expectedId);

        assertNotNull(actualCustomerData);
        assertEquals(expectedId, actualCustomerData.id());
        assertEquals(expectedName, actualCustomerData.name());
        assertEquals(expectedSegmentName, actualCustomerData.segmentName());

        verify(customerClient, times(1)).getUserById(eq(expectedId));
    }

    @Test
    public void givenAnInvalidId_whenGetCustomerByName_thenReturnEntityNotFoundException() {
        final var expectedErrorMessage = "Error getting customer by id";
        long expectedId = 123456L;

        when(customerClient.getUserById(eq(expectedId)))
                .thenThrow(FeignException.NotFound.class);

        final var actualException = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> customerService.getCustomerById(expectedId)
        );

        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

        verify(customerClient, times(1)).getUserById(eq(expectedId));
    }

    @Test
    void givenAValidName_whenGetCustomerByName_thenReturnCustomer(){
        long expectedId = 1L;
        String expectedName = "John Doe";
        String expectedSegmentName = "segmentName";
        CustomerData customerData = new CustomerData(expectedId, expectedName, expectedSegmentName, null, null);

        when(customerClient.getUserByName(eq(expectedName)))
                .thenReturn(customerData);

        CustomerData actualCustomerData = customerService.getCustomerByName(expectedName);

        assertNotNull(actualCustomerData);
        assertEquals(expectedId, actualCustomerData.id());
        assertEquals(expectedName, actualCustomerData.name());
        assertEquals(expectedSegmentName, actualCustomerData.segmentName());

        verify(customerClient, times(1)).getUserByName(eq(expectedName));
    }

    @Test
    public void givenAnInvalidName_whenGetCustomerByName_thenReturnEntityNotFoundException() {
        final var expectedErrorMessage = "Error getting customer by name";
        String expectedName = "123456L";

        when(customerClient.getUserByName(eq(expectedName)))
                .thenThrow(FeignException.NotFound.class);

        final var actualException = Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> customerService.getCustomerByName(expectedName)
        );

        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

        verify(customerClient, times(1)).getUserByName(eq(expectedName));
    }
}
