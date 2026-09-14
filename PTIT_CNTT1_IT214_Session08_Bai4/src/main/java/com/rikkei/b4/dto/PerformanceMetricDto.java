package com.rikkei.b4.dto;

public record PerformanceMetricDto(
    String scenario,
    int concurrentUsers,
    double requestsPerSecond,
    double avgLatencyMs,
    double p99LatencyMs,
    double errorRatePercentage,
    String resilienceStatus
) {}
