package com.michalkolos.nextbikeloger.business.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.michalkolos.nextbikeloger.data.entity.Weather;
import com.michalkolos.nextbikeloger.data.serial.WeatherDeserializer;
import org.springframework.stereotype.Service;

@Service
public class WeatherDeserializationService extends DeserializationService {

	public Weather deserialize(String rawString) throws JsonProcessingException{

		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Weather.class, new WeatherDeserializer());
		mapper.registerModule(module);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return mapper.readValue(rawString, Weather.class);
	}
}
