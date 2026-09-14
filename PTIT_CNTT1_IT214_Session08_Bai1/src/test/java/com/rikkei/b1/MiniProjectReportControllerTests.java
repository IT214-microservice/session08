package com.rikkei.b1;

import com.rikkei.b1.controller.MiniProjectReportController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MiniProjectReportController.class)
class MiniProjectReportControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetReport() throws Exception {
        mockMvc.perform(get("/api/project/report"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.projectName").value("VietMart Banking & Microservices Platform"))
                .andExpect(jsonPath("$.data.evaluationStatus").value("COMPLETED_100_PERCENT"));
    }
}
