package com.michalkolos.nextbikeloger.data.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Bike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BIKE_ID")
	private long id;

	@Column(name = "BIKE_NUMBER")
	private int bike_number;

	@OneToMany(mappedBy = "bike")
	private Set<BikeStatus> bikeStatuses;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBike_number() {
		return bike_number;
	}

	public void setBike_number(int bike_number) {
		this.bike_number = bike_number;
	}

	public Set<BikeStatus> getBikeStatuses() {
		return bikeStatuses;
	}

	public void setBikeStatuses(Set<BikeStatus> bikeStatuses) {
		this.bikeStatuses = bikeStatuses;
	}
}
