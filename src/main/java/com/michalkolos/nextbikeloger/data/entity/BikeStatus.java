package com.michalkolos.nextbikeloger.data.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.michalkolos.nextbikeloger.data.serial.BikeDeserializer;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@JsonDeserialize(using = BikeDeserializer.class)
public class BikeStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BIKE_STATUS_ID")
	private long id;

	private Timestamp timestamp;
	@Column(name = "ACTIVE")
	private int active;
	@Column(name = "STATE")
	private String state;

	@Column(name = "PEDELEC_BATTERY")
	private int pedelec_battery;

	@ManyToOne
	@JoinColumn(name = "PLACE_ID")
	private Place place;

	@ManyToOne
	@JoinColumn(name = "BIKE_ID")
	private Bike bike;

//	@JsonCreator
	public BikeStatus(){}

//	@JsonCreator
//	public BikeStatus(

//			@JacksonXmlProperty(localName = "active", isAttribute = true)
//			int active,
//
//			@JacksonXmlProperty(localName = "state", isAttribute = true)
//			String  state,
//
//			@JacksonXmlProperty(localName = "bike_type", isAttribute = true)
//			int bike_type,
//
//			@JacksonXmlProperty(localName = "lock_types", isAttribute = true)
//			String lock_types,
//
//			@JacksonXmlProperty(localName = "electric_lock", isAttribute = true)
//			int electric_lock,
//
//			@JacksonXmlProperty(localName = "boardcomputer", isAttribute = true)
//			int boardcomputer,
//
//			@JacksonXmlProperty(localName = "pedelec_battery", isAttribute = true)
//			String pedelec_battery
//	){
//		this.active = active;
//		this.state = state;
//		this.bike_type = bike_type;
//		this.lock_types = lock_types;
//		this.electric_lock = electric_lock;
//		this.boardcomputer = boardcomputer;
//		this.pedelec_battery = pedelec_battery;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPedelec_battery() {
		return pedelec_battery;
	}

	public void setPedelec_battery(int pedelec_battery) {
		this.pedelec_battery = pedelec_battery;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}
}
