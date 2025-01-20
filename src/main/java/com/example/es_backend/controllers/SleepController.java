package com.example.es_backend.controllers;

import com.example.es_backend.models.SleepData;
import com.example.es_backend.repositories.SleepDataRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@Tag(name = "Sleep Controller", description = "Контроллер для админ панели")
public class SleepController {
    private SleepDataRepository sleepDataRepository;

    @Autowired
    public SleepController(SleepDataRepository sleepDataRepository) {
        this.sleepDataRepository = sleepDataRepository;
    }

    @GetMapping("/sleep/{sleepId}")
    public List<SleepData> getAllSleepData(@PathVariable Long sleepId) {
        List<SleepData> sleepData = sleepDataRepository.findBySleepId(sleepId);
        return sleepData;
    }
}