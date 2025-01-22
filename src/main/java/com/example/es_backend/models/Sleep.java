package com.example.es_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

@Entity(name = "sleeps")
@Data
public class Sleep {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "alarm_time")
    private Timestamp alarmTime;
    @Column(name = "alarm_pause")
    private Integer alarmPause;
}
