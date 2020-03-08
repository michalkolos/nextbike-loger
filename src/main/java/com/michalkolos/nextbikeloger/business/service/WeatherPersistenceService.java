package com.michalkolos.nextbikeloger.business.service;

import com.michalkolos.nextbikeloger.business.scheduled.ScheduledTasks;
import com.michalkolos.nextbikeloger.data.entity.Weather;
import com.michalkolos.nextbikeloger.data.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherPersistenceService {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	WeatherRepository weatherRepository;

	@Autowired
	WeatherPersistenceService( WeatherRepository weatherRepository){
		this.weatherRepository = weatherRepository;
	}


	public void save (Weather weather){

		Weather previousWeather = weatherRepository.findFirstByOrderByCalculatedTimeDesc();

		if(previousWeather == null ||
				weather.getCalculatedTime().toLocalDateTime().isAfter(previousWeather.getCalculatedTime().toLocalDateTime())){

			weatherRepository.save(weather);

			log.info("Weather calculated at: {} saved to database",
					weather.getCalculatedTime().toLocalDateTime());
		}else{
			log.info("Weather ignored, more recent already in the database: {}",
					previousWeather.getCalculatedTime().toLocalDateTime());
		}


	}

}
