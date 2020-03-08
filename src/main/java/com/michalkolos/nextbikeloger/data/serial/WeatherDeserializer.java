package com.michalkolos.nextbikeloger.data.serial;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.michalkolos.nextbikeloger.business.scheduled.ScheduledTasks;
import com.michalkolos.nextbikeloger.data.entity.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;

public class WeatherDeserializer extends StdDeserializer<Weather> {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	public WeatherDeserializer(){
		this(null);
	}

	public WeatherDeserializer(Class<?> vc) {
		super(vc);
	}


	@Override
	public Weather deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

		JsonNode jsonNode = deserializationContext.readTree(jsonParser);
		Weather weather = new Weather();

		try {
			weather.setCalculatedTime(new Timestamp(jsonNode.get("dt").asLong() * 1000));
			weather.setClouds(jsonNode.get("clouds").get("all").asInt());
			weather.setCondition_id(jsonNode.get("weather").get(0).get("id").asInt());
			weather.setDescription(jsonNode.get("weather").get(0).get("description").asText());
			weather.setHuman_temp(jsonNode.get("main").get("feels_like").asDouble());
			weather.setHumidity(jsonNode.get("main").get("humidity").asInt());
			weather.setPressure(jsonNode.get("main").get("pressure").asInt());
			weather.setTemp(jsonNode.get("main").get("temp").asDouble());
			weather.setVisibility(jsonNode.get("visibility").asInt());
			weather.setWind_deg(jsonNode.get("wind").get("deg").asInt());
			weather.setWind_speed(jsonNode.get("wind").get("speed").asDouble());

			log.info("Downloaded weather for date: {} => {} / clouds: {} / temp: {}({}) / wind: {}({})",
					weather.getCalculatedTime().toString(),
					weather.getDescription(),
					Integer.toString(weather.getClouds()),
					Double.toString(weather.getTemp()),
					Double.toString(weather.getHuman_temp()),
					Double.toString(weather.getWind_speed()),
					Integer.toString(weather.getWind_deg())
			);

		}catch (NullPointerException e){
			log.error("Error parsing weather data.");
		}

		return weather;
	}
}
