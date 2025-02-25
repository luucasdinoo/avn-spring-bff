package com.demo.spring_bff.application.dto;

import java.util.List;

public record CustomerData(
        Long id,
        String name,
        String segmentName,
        List<CustomerDocumentData> documents,
        List<CustomerContactData> contacts
){
}
