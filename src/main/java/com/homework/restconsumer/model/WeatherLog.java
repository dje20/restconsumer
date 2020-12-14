package com.homework.restconsumer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class WeatherLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String responseId;
    private String location;
    private String actualWeather;
    private String temperature;
    private LocalDateTime dtimeInserted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getActualWeather() {
        return actualWeather;
    }

    public void setActualWeather(String actualWeather) {
        this.actualWeather = actualWeather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getDtimeInserted() {
        return dtimeInserted;
    }

    public void setDtimeInserted(LocalDateTime dtimeInserted) {
        this.dtimeInserted = dtimeInserted;
    }

    @Override
    public String toString() {
        return "WeatherLog{" +
                "id=" + id +
                ", responseId='" + responseId + '\'' +
                ", location='" + location + '\'' +
                ", actualWeather='" + actualWeather + '\'' +
                ", temperature='" + temperature + '\'' +
                ", dtimeInserted=" + dtimeInserted +
                '}';
    }
}
