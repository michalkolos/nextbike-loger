package com.michalkolos.nextbikeloger.data.repository;

import com.michalkolos.nextbikeloger.data.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	public List<City> findAllByUid(int uid);
	public City findByUid(int uid);
}
