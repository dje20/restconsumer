package com.homework.restconsumer.service;

import com.homework.restconsumer.model.WeatherApiDto;
import com.homework.restconsumer.model.WeatherLog;
import com.homework.restconsumer.repository.WeatherLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class WeatherService {

    @Autowired
    WeatherLogRepository weatherLogRepository;

    //ID taken from account made
    public static final String AppId = "806550565fb43de2fe22a89a31ec8098";

    public WeatherLog getAndSaveCurrentWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();

        WeatherApiDto dto = new WeatherApiDto();
        try {
            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + AppId;
            dto = restTemplate.getForObject(url, WeatherApiDto.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        WeatherLog weatherLog = null;
        if (dto != null) {
            weatherLog = new WeatherLog();
            weatherLog.setResponseId(String.valueOf(dto.getId()));
            weatherLog.setLocation(dto.getName());

            String weatherDescription;
            if(dto.getWeather().size() > 0) {
                weatherDescription = dto.getWeather().get(0).getDescription();
            } else {
                weatherDescription = "unknown";
            }
            weatherLog.setActualWeather(weatherDescription);
            weatherLog.setTemperature(String.valueOf(dto.getMain().getTemp()));

            weatherLog.setDtimeInserted(LocalDateTime.now());

            weatherLogRepository.save(weatherLog);
        }

        return weatherLog;
    }

}
