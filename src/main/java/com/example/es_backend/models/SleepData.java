package com.example.es_backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Entity
@Getter
@Setter
public class SleepData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long sleepId;

    private Timestamp time;
    private float data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSleepId() {
        return sleepId;
    }

    public void setSleepId(long sleepId) {
        this.sleepId = sleepId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }
}
