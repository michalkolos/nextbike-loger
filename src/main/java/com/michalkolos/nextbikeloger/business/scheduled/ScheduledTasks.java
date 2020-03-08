package com.michalkolos.nextbikeloger.business.scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.michalkolos.nextbikeloger.business.service.*;
import com.michalkolos.nextbikeloger.data.entity.Markers;
import com.michalkolos.nextbikeloger.data.entity.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	DataDownloadService dataDownloadService;
	DataDeserializationService dataDeserializationService;
	DataPersistenceService dataPersistenceService;

	WeatherDeserializationService weatherDeserializationService;
	WeatherPersistenceService weatherPersistenceService;

	@Autowired
	public ScheduledTasks(
			DataDeserializationService dataDeserializationService,
			DataDownloadService dataDownloadService,
			DataPersistenceService dataPersistenceService,
			WeatherDeserializationService weatherDeserializationService,
			WeatherPersistenceService weatherPersistenceService
	){
		this.dataDeserializationService = dataDeserializationService;
		this.dataDownloadService = dataDownloadService;
		this.dataPersistenceService = dataPersistenceService;
		this.weatherDeserializationService = weatherDeserializationService;
		this.weatherPersistenceService = weatherPersistenceService;
	}

	@Scheduled(fixedRate = 5 * 60000)
	public void logBikes(){
		log.info("Started logging task");

		try {

			String xmlString = dataDownloadService.download("http://api.nextbike.net/maps/nextbike-official.xml?city=210");
			Markers markers = dataDeserializationService.deserialize(xmlString);
			dataPersistenceService.save(markers);


		}catch (MalformedURLException e) {
			log.error("Error forming url to Nextbike API.");
		}catch (JsonProcessingException e){
			log.error("Unable to process xml data.");

			e.printStackTrace();
		}catch (IOException e) {
			log.error("Error getting data from Nextbike API.");
		}

		try {

			String weatherString = dataDownloadService.download("http://api.openweathermap.org/data/2.5/weather?q=Warsaw,pl&units=metric&APPID=216353d6d8f732836dc5f5cd45404903");
			Weather weather = weatherDeserializationService.deserialize(weatherString);
			weatherPersistenceService.save(weather);

		}catch (MalformedURLException e) {
			log.error("Error forming url to Open Weather API.");
		}catch (JsonProcessingException e){
			log.error("Unable to process JSON data.");

			e.printStackTrace();
		}catch (IOException e) {
			log.error("Error getting data from Open Weather API.");
		}


		log.info("Logging complete");
	}

//	@Scheduled(fixedRate = 10000)
//	public void logWeather() {
//
//		log.info("Started logging task");
//
//		try {
//			String weatherString = dataDownloadService.download("http://api.openweathermap.org/data/2.5/weather?q=Warsaw,pl&units=metric&APPID=216353d6d8f732836dc5f5cd45404903");
//			Weather weather = weatherDeserializationService.deserialize(weatherString);
//			weatherPersistenceService.save(weather);
//
//		}catch (MalformedURLException e) {
//			log.error("Error forming url to Open Weather API.");
//		}catch (JsonProcessingException e){
//			log.error("Unable to process JSON data.");
//
//			e.printStackTrace();
//		}catch (IOException e) {
//			log.error("Error getting data from Open Weather API.");
//		}
//
//
//		log.info("Logging complete");
//
//	}
}
