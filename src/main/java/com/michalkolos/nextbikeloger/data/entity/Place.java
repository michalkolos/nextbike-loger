package com.michalkolos.nextbikeloger.data.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.michalkolos.nextbikeloger.data.serial.BikeDeserializer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLACE_ID")
	private long id;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "UID")
	private int uid;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "LAT")
	private double lat;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "LNG")
	private double lng;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "NAME")
	private String name;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "SPOT")
	private int spot;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "NUMBER")
	private int number;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "BIKES")
	private int bikes;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "BOOKED_BIKES")
	private int booked_bikes;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "FREE_RACKS")
	private int free_racks;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "TERMINAL_TYPE")
	private String terminal_type;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "BIKE_TYPES")
	private String bike_types;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "PLACE_TYPES")
	private String place_type;

	@ManyToOne
	@JoinColumn
	private City city;


	@OneToMany(mappedBy = "place")
	@JacksonXmlProperty(localName = "bike")
	private Set<BikeStatus> bikeStatus = new HashSet<>();


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpot() {
		return spot;
	}

	public void setSpot(int spot) {
		this.spot = spot;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBikes() {
		return bikes;
	}

	public void setBikes(int bikes) {
		this.bikes = bikes;
	}

	public int getBooked_bikes() {
		return booked_bikes;
	}

	public void setBooked_bikes(int booked_bikes) {
		this.booked_bikes = booked_bikes;
	}

	public int getFree_racks() {
		return free_racks;
	}

	public void setFree_racks(int free_racks) {
		this.free_racks = free_racks;
	}

	public String getTerminal_type() {
		return terminal_type;
	}

	public void setTerminal_type(String terminal_type) {
		this.terminal_type = terminal_type;
	}

	public String getBike_types() {
		return bike_types;
	}

	public void setBike_types(String bike_types) {
		this.bike_types = bike_types;
	}

	public String getPlace_type() {
		return place_type;
	}

	public void setPlace_type(String place_type) {
		this.place_type = place_type;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<BikeStatus> getBikeStatus() {
		return bikeStatus;
	}

	public void setBikeStatus(Set<BikeStatus> bikeStatus) {
		this.bikeStatus = bikeStatus;
	}
}
