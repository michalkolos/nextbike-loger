package com.michalkolos.nextbikeloger.data.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BIKE_ID")
	private long id;

	@Column(name = "NUMBER")
	private int number;

	@Column(name = "BIKE_TYPE")
	private int bike_type;

	@OneToMany(mappedBy = "bike")
	private Set<BikeStatus> bikeStatuses = new HashSet<>();



	public boolean equals(Object o) {
		return (o instanceof Bike) && (((Bike)o).getNumber() == this.getNumber());
	}

	public int hashCode() {
		return this.getNumber();
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBike_type() {
		return bike_type;
	}

	public void setBike_type(int bike_type) {
		this.bike_type = bike_type;
	}

	public Set<BikeStatus> getBikeStatuses() {
		return bikeStatuses;
	}

	public void setBikeStatuses(Set<BikeStatus> bikeStatuses) {
		this.bikeStatuses = bikeStatuses;
	}
}
