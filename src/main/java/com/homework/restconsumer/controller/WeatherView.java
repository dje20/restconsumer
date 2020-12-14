package com.homework.restconsumer.controller;

import com.homework.restconsumer.model.WeatherLog;
import com.homework.restconsumer.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherView {

    @Autowired
    private WeatherService weatherService;

    @ResponseBody
    @GetMapping("/weather-view/city/{city}")
    public String viewByCity(@PathVariable("city") String city) {

        WeatherLog weatherLog = weatherService.getAndSaveCurrentWeather(city);

        return weatherLog.toString();
    }
}
