package com.rikkei.b2.dto;

public record AccountDto(
    Long accountId,
    Long customerId,
    Double balance,
    String status
) {}
