package com.arikaran.jobtracker.dto;

import java.time.LocalDate;

public record JobRequest(
        Long userId,
        Long companyId,
        String jobTitle,
        LocalDate appliedDate
) {}