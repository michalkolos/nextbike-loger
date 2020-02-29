package com.michalkolos.nextbikeloger.business;

import com.michalkolos.nextbikeloger.business.scheduled.ScheduledTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

public class RawData {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	public static String downloadXml(String urlString){

		URL url = null;
		String rawXmlString = null;

		try{
			url = new URL(urlString);
		}catch (MalformedURLException e){

			log.info("Malformed URL: {}", urlString);
		}


		try {
			Scanner scanner = new Scanner(url.openStream(), StandardCharsets.UTF_8.toString());
			scanner.useDelimiter("\\A");
			rawXmlString = scanner.hasNext() ? scanner.next() : "";
		}catch(Exception e){
			log.info("Unable to download file.")
		}

		return  rawXmlString;
	}
}
