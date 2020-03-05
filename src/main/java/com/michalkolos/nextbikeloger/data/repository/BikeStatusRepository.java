package com.michalkolos.nextbikeloger.data.repository;

import com.michalkolos.nextbikeloger.data.entity.Bike;
import com.michalkolos.nextbikeloger.data.entity.BikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeStatusRepository extends JpaRepository<BikeStatus, Long> {
	public BikeStatus getTopByBikeOrderByTimestampDesc(Bike bike);

}
