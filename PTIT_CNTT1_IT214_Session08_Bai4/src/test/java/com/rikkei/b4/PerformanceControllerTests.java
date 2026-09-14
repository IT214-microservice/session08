package com.rikkei.b4;

import com.rikkei.b4.controller.PerformanceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PerformanceController.class)
class PerformanceControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetMetrics() throws Exception {
        mockMvc.perform(get("/api/performance/metrics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data[0].scenario").value("Baseline Single Instance (No Circuit Breaker)"))
                .andExpect(jsonPath("$.data[1].resilienceStatus").value("HIGHLY_AVAILABLE"))
                .andExpect(jsonPath("$.data[2].requestsPerSecond").value(3200.0));
    }
}
