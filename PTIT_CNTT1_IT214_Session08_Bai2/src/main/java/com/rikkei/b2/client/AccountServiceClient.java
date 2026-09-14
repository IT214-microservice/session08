package com.rikkei.b2.client;

import com.rikkei.b2.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service")
public interface AccountServiceClient {

    @GetMapping("/api/accounts/{accountId}")
    AccountDto getAccount(@PathVariable("accountId") Long accountId);
}
