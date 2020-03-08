package com.michalkolos.nextbikeloger.business.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.michalkolos.nextbikeloger.data.entity.*;
import org.springframework.stereotype.Service;


@Service
public class DataDeserializationService extends DeserializationService{

	public Markers deserialize(String xmlString) throws JsonProcessingException {

		Markers markers = super.getXmlMapper().readValue(xmlString, Markers.class);


		for (Country country: markers.getCountry()) {

			for(City city: country.getCity()){
				city.setCountry(country);

				for(Place place: city.getPlace()){
					place.setCity(city);

					for(BikeStatus bikeStatus: place.getBikeStatus()){
						bikeStatus.setPlace(place);
					}
				}
			}
		}

		return markers;
	}
}
