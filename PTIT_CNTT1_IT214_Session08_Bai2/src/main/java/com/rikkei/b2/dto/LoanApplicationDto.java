package com.rikkei.b2.dto;

public record LoanApplicationDto(
    Long customerId,
    Long accountId,
    Double requestedAmount
) {}
