package com.example.es_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class SleepSummaryDto {
    private long sleepId;
    private Timestamp startTime;
    private Timestamp endTime;
}
