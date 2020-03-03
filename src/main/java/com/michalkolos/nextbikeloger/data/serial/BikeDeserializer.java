package com.michalkolos.nextbikeloger.data.serial;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.michalkolos.nextbikeloger.business.scheduled.ScheduledTasks;
import com.michalkolos.nextbikeloger.data.entity.Bike;
import com.michalkolos.nextbikeloger.data.entity.BikeStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;

public class BikeDeserializer extends StdDeserializer<BikeStatus> {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	public BikeDeserializer(){
		this(null);
	}

	public BikeDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public BikeStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

		JsonNode jsonNode = deserializationContext.readTree(jsonParser);
		BikeStatus bikeStatus = new BikeStatus();


		try {
//			System.out.println(jsonNode.toString());

			bikeStatus.setTimestamp( new Timestamp(System.currentTimeMillis()));
			bikeStatus.setActive(jsonNode.get("active").asInt());
			bikeStatus.setState(jsonNode.get("state").asText());

			if(!jsonNode.get("pedelec_battery").asText().isEmpty()){
				bikeStatus.setPedelec_battery(jsonNode.get("pedelec_battery").asInt());
			}else{
				bikeStatus.setPedelec_battery(-1);
			}

			Bike bike = new Bike();

			bike.setNumber(jsonNode.get("number").asInt());
			bike.setBike_type(jsonNode.get("bike_type").asInt());

			bike.getBikeStatuses().add(bikeStatus);
			bikeStatus.setBike(bike);

		}catch (NullPointerException e){
			log.warn("Wrong bike data format");
		}

		return bikeStatus;
	}
}
