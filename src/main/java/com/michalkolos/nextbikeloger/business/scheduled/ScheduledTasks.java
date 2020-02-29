package com.michalkolos.nextbikeloger.business.scheduled;

import com.michalkolos.nextbikeloger.business.BikeLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//	@Scheduled(fixedRate = 2000)
//	public void reportCurrentTime() {
//		log.info("The time is now {}", dateFormat.format(new Date()));
//
//	}

	@Scheduled(fixedRate = 10000)
	public void logBikes(){
		log.info("Started logging task");

		BikeLogger.run();


	}
}
