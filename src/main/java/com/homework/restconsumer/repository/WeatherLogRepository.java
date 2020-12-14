package com.homework.restconsumer.repository;

import com.homework.restconsumer.model.WeatherLog;
import org.springframework.data.repository.CrudRepository;

public interface WeatherLogRepository extends CrudRepository<WeatherLog, Long> {

}
