package com.michalkolos.nextbikeloger.data.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
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
	@Column(name = "BIKE_TYPE")
	private int bike_type;
	@Column(name = "LOCK_TYPES")
	private String lock_types;
	@Column(name = "ELECTRIC_LOCK")
	private int electric_lock;
	@Column(name = "BOARDCOMPUTER")
	private int boardcomputer;
	@Column(name = "PEDELEC_BATTERY")
	private String pedelec_battery;

	@ManyToOne
	@JoinColumn(name = "PLACE_ID")
	private Place place;

	@ManyToOne
	@JoinColumn(name = "BIKE_ID")
	private Bike bike;


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

	public int getBike_type() {
		return bike_type;
	}

	public void setBike_type(int bike_type) {
		this.bike_type = bike_type;
	}

	public String getLock_types() {
		return lock_types;
	}

	public void setLock_types(String lock_types) {
		this.lock_types = lock_types;
	}

	public int getElectric_lock() {
		return electric_lock;
	}

	public void setElectric_lock(int electric_lock) {
		this.electric_lock = electric_lock;
	}

	public int getBoardcomputer() {
		return boardcomputer;
	}

	public void setBoardcomputer(int boardcomputer) {
		this.boardcomputer = boardcomputer;
	}

	public String getPedelec_battery() {
		return pedelec_battery;
	}

	public void setPedelec_battery(String pedelec_battery) {
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
