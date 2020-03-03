package com.michalkolos.nextbikeloger.business.scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.michalkolos.nextbikeloger.business.service.DataDeserializationService;
import com.michalkolos.nextbikeloger.business.service.DataDownloadService;
import com.michalkolos.nextbikeloger.data.entity.Markers;
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


	@Autowired
	public ScheduledTasks(
			DataDeserializationService dataDeserializationService,
			DataDownloadService dataDownloadService
	){
		this.dataDeserializationService = dataDeserializationService;
		this.dataDownloadService = dataDownloadService;
	}

	@Scheduled(fixedRate = 10000)
	public void logBikes(){
		log.info("Started logging task");

		try {

			String xmlString = dataDownloadService.download("http://api.nextbike.net/maps/nextbike-official.xml");
			Markers markers = dataDeserializationService.deserialize(xmlString);


		}catch (MalformedURLException e) {
			log.error("Error forming url to Nextbike API.");
		}catch (JsonProcessingException e){
			log.error("Unable to process xml data.");
		}catch (IOException e) {
			log.error("Error getting data from Nextbike API.");
		}


		log.info("Logging complete");
	}
}
