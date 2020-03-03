package com.michalkolos.nextbikeloger.data.repository;

import com.michalkolos.nextbikeloger.data.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
	public List<Place> findAllByUid(int uid);
	public Place findByUid(int uid);
}
