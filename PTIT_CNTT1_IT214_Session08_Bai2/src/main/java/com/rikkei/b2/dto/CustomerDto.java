package com.rikkei.b2.dto;

public record CustomerDto(
    Long customerId,
    String fullName,
    Integer creditScore,
    String status
) {}
