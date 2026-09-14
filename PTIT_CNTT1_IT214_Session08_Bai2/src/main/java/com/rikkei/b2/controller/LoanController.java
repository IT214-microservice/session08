package com.rikkei.b2.controller;

import com.rikkei.b2.client.AccountServiceClient;
import com.rikkei.b2.client.CustomerServiceClient;
import com.rikkei.b2.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final CustomerServiceClient customerClient;
    private final AccountServiceClient accountClient;

    public LoanController(CustomerServiceClient customerClient, AccountServiceClient accountClient) {
        this.customerClient = customerClient;
        this.accountClient = accountClient;
    }

    @PostMapping("/apply")
    public ResponseEntity<ApiResponse<LoanResponseDto>> applyForLoan(@RequestBody LoanApplicationDto request) {
        CustomerDto customer = customerClient.getCustomer(request.customerId());
        if (customer == null || customer.creditScore() < 600) {
            LoanResponseDto rejected = new LoanResponseDto(
                UUID.randomUUID().toString(),
                request.customerId(),
                request.requestedAmount(),
                0.0,
                "REJECTED",
                "Credit score too low (Required >= 600)",
                LocalDateTime.now()
            );
            return ResponseEntity.status(400).body(ApiResponse.error("Loan rejected: Low credit score"));
        }

        AccountDto account = accountClient.getAccount(request.accountId());
        if (account == null || !"ACTIVE".equalsIgnoreCase(account.status())) {
            return ResponseEntity.status(400).body(ApiResponse.error("Loan rejected: Account inactive"));
        }

        LoanResponseDto approved = new LoanResponseDto(
            UUID.randomUUID().toString(),
            request.customerId(),
            request.requestedAmount(),
            request.requestedAmount(),
            "APPROVED",
            "Loan application approved based on credit score (" + customer.creditScore() + ") and active account balance ($" + account.balance() + ")",
            LocalDateTime.now()
        );

        return ResponseEntity.ok(ApiResponse.success("Loan approved successfully", approved));
    }
}
