package com.rikkei.b2.dto;

import java.time.LocalDateTime;

public record LoanResponseDto(
    String loanId,
    Long customerId,
    Double requestedAmount,
    Double approvedAmount,
    String status,
    String remarks,
    LocalDateTime timestamp
) {}
