package com.rikkei.b4.controller;

import com.rikkei.b4.dto.ApiResponse;
import com.rikkei.b4.dto.PerformanceMetricDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {

    @GetMapping("/metrics")
    public ApiResponse<List<PerformanceMetricDto>> getMetrics() {
        List<PerformanceMetricDto> metrics = List.of(
            new PerformanceMetricDto("Baseline Single Instance (No Circuit Breaker)", 100, 450.0, 220.0, 1500.0, 12.5, "DEGRADED"),
            new PerformanceMetricDto("Multi-Instance Load Balanced (3 Nodes)", 500, 1850.0, 45.0, 180.0, 0.1, "HIGHLY_AVAILABLE"),
            new PerformanceMetricDto("High Load with Resilience4j Circuit Breaker Active", 1000, 3200.0, 15.0, 40.0, 0.0, "PROTECTED_CIRCUIT_OPEN")
        );
        return ApiResponse.success("Performance benchmark metrics generated successfully", metrics);
    }
}
