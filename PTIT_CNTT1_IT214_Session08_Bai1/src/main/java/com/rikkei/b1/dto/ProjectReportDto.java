package com.rikkei.b1.dto;

import java.util.List;

public record ProjectReportDto(
    String projectName,
    String teamName,
    String architectureOverview,
    List<String> implementedFeatures,
    List<String> refactoredImprovements,
    String evaluationStatus
) {}
