package com.michalkolos.nextbikeloger.data.repository;

import com.michalkolos.nextbikeloger.data.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
	public List<Bike> findAllByNumber(int number);
	public Bike findByNumber(int number);
}
