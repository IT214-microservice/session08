package com.rikkei.b1.controller;

import com.rikkei.b1.dto.ApiResponse;
import com.rikkei.b1.dto.ProjectReportDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class MiniProjectReportController {

    @GetMapping("/report")
    public ApiResponse<ProjectReportDto> getReport() {
        ProjectReportDto report = new ProjectReportDto(
            "VietMart Banking & Microservices Platform",
            "Group 07 - PTIT CNTT1",
            "Microservices Architecture using Spring Cloud Config Server, Eureka Service Discovery, Spring Cloud Gateway, OpenFeign, and Resilience4j",
            List.of(
                "Centralized Configuration Management with Spring Cloud Config Server",
                "Service Registration & Discovery with Eureka Server Cluster",
                "Dynamic API Gateway Routing & Client-side Load Balancing",
                "Synchronous Inter-Service Communication via RestTemplate & OpenFeign",
                "Circuit Breaker & Fallback Resilience with Resilience4j"
            ),
            List.of(
                "Fixed Gateway hardcoded http:// URLs to lb:// dynamic load balanced URIs",
                "Isolated load balancer configuration scope to prevent ZonePreference pollution",
                "Added connectTimeout and readTimeout to RestTemplate to prevent cascading failures",
                "Applied @JsonAlias to DTOs for backward-compatible API contract evolution"
            ),
            "COMPLETED_100_PERCENT"
        );
        return ApiResponse.success("Mini Project Practicum Report retrieved successfully", report);
    }
}
