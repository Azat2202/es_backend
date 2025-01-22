package com.example.es_backend.repositories;

import com.example.es_backend.models.Sleep;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SleepRepository extends JpaRepository<Sleep, Long> {
    @Query("SELECT s FROM sleeps s WHERE s.id = (SELECT MAX(m.id) FROM sleeps m)")
    Optional<Sleep> findMaxIdEntity();

}
