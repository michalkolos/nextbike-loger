package com.michalkolos.nextbikeloger.business.service;

import com.michalkolos.nextbikeloger.business.scheduled.ScheduledTasks;
import com.michalkolos.nextbikeloger.data.entity.City;
import com.michalkolos.nextbikeloger.data.entity.Country;
import com.michalkolos.nextbikeloger.data.entity.Markers;
import com.michalkolos.nextbikeloger.data.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataPersistenceService {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	CountryRepository countryRepository;
	CityRepository cityRepository;
	PlaceRepository placeRepository;
	BikeStatusRepository bikeStatusRepository;
	BikeRepository bikeRepository;

	@Autowired
	public DataPersistenceService(
			CountryRepository countryRepository,
			CityRepository cityRepository,
			PlaceRepository placeRepository,
			BikeStatusRepository bikeStatusRepository,
			BikeRepository bikeRepository
	){
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
		this.placeRepository = placeRepository;
		this.bikeStatusRepository = bikeStatusRepository;
		this.bikeRepository = bikeRepository;
	}


	public void save(Markers markers){

		for(Country country: markers.getCountry()){

			Country storedCountry = countryRepository.findByName(country.getName());

//			if(storedCountry == null){
//
//			}

		}
	}
}
