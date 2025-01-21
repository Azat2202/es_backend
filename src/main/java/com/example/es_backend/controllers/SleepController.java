package com.example.es_backend.controllers;

import com.example.es_backend.dto.SleepSummaryDto;
import com.example.es_backend.models.SleepData;
import com.example.es_backend.repositories.SleepDataRepository;
import com.example.es_backend.services.SleepGraphService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@Tag(name = "Sleep Controller", description = "Контроллер для админ панели")
public class SleepController {
    private final SleepDataRepository sleepDataRepository;
    private final SleepGraphService sleepGraphService;

    @GetMapping("/sleep/")
    public List<SleepSummaryDto> getSleepSummaries() {
        List<Object[]> results = sleepDataRepository.findDistinctSleepIdsWithTimeRange();
        List<SleepSummaryDto> summaries = new ArrayList<>();

        for (Object[] result : results) {
            long sleepId = (Long) result[0];
            Timestamp startTime = (Timestamp) result[1];
            Timestamp endTime = (Timestamp) result[2];
            summaries.add(new SleepSummaryDto(sleepId, startTime, endTime));
        }

        return summaries;
    }

    @GetMapping("/sleep/{sleepId}")
    public List<SleepData> getAllSleepData(@PathVariable Long sleepId) {
        return sleepDataRepository.findBySleepId(sleepId);
    }

    @GetMapping("/sleep/{sleepId}/graph")
    public List<Boolean> getSleepDataGraph(@PathVariable Long sleepId) {
        var data = sleepGraphService.getSleepGraphData(
                sleepDataRepository.findBySleepId(sleepId)
        );
        // easy export to excel)
//        System.out.println(String.join("\n",
//                data.stream()
//                        .map(a -> a ? "1" : "0")
//                        .toList()));
        return data;
    }


}