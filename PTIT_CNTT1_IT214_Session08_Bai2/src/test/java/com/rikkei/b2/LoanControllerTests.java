package com.rikkei.b2;

import com.rikkei.b2.client.AccountServiceClient;
import com.rikkei.b2.client.CustomerServiceClient;
import com.rikkei.b2.controller.LoanController;
import com.rikkei.b2.dto.AccountDto;
import com.rikkei.b2.dto.CustomerDto;
import com.rikkei.b2.dto.LoanApplicationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoanController.class)
class LoanControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerServiceClient customerClient;

    @MockBean
    private AccountServiceClient accountClient;

    @Test
    void testApplyForLoanApproved() throws Exception {
        CustomerDto customer = new CustomerDto(100L, "Le Van C", 720, "ACTIVE");
        AccountDto account = new AccountDto(200L, 100L, 10000.0, "ACTIVE");

        given(customerClient.getCustomer(100L)).willReturn(customer);
        given(accountClient.getAccount(200L)).willReturn(account);

        LoanApplicationDto req = new LoanApplicationDto(100L, 200L, 5000.0);

        mockMvc.perform(post("/api/loans/apply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.status").value("APPROVED"))
                .andExpect(jsonPath("$.data.approvedAmount").value(5000.0));
    }
}
