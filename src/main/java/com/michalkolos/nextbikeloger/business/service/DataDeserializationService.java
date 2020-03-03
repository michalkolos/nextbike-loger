package com.michalkolos.nextbikeloger.business.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.michalkolos.nextbikeloger.data.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DataDeserializationService {

	public Markers deserialize(String xmlString) throws JsonProcessingException {

		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		XmlMapper xmlMapper = new XmlMapper(module);
		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		xmlMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		xmlMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

		Markers markers = xmlMapper.readValue(xmlString, Markers.class);


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
