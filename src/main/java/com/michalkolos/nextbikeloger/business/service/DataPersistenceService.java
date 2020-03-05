package com.michalkolos.nextbikeloger.business.service;

import com.michalkolos.nextbikeloger.business.scheduled.ScheduledTasks;
import com.michalkolos.nextbikeloger.data.entity.*;
import com.michalkolos.nextbikeloger.data.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

			Country oldCountry = countryRepository.findByName(country.getName());
			if(oldCountry != null){
				country.setId(oldCountry.getId());
			}

			for(City city: country.getCity()){

				City oldCity = cityRepository.findByUid(city.getUid());
				if(oldCity != null){
					city.setId(oldCity.getId());
				}

				for(Place place: city.getPlace()){

					Place oldPlace = placeRepository.findByUid(place.getUid());
					if(oldPlace != null){
						place.setId(oldPlace.getId());
					}
				}
			}
			countryRepository.save(country);
		}

		for(Country country: markers.getCountry()){
			for(City city: country.getCity()){
				for(Place place: city.getPlace()){
					for(BikeStatus bikeStatus: place.getBikeStatus()){
						if(bikeStatus.getBike() == null){
							log.error("Null pointer to a bike!");
						}else{
							Bike oldBike = bikeRepository.findByNumber(bikeStatus.getBike().getNumber());

							if(oldBike != null){
								bikeStatus.getBike().setId(oldBike.getId());
							}

							bikeRepository.save(bikeStatus.getBike());
							bikeStatusRepository.save(bikeStatus);
						}
					}
				}
			}
		}
	}
}
