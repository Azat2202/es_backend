package com.example.es_backend.repositories;

import com.example.es_backend.models.SleepData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SleepDataRepository extends JpaRepository<SleepData, Long> {
    List<SleepData> findBySleepId(long sleepId);

    @Query("SELECT s.sleepId, MIN(s.time), MAX(s.time) FROM SleepData s GROUP BY s.sleepId ORDER BY MAX(s.time) DESC")
    List<Object[]> findDistinctSleepIdsWithTimeRange();
}
