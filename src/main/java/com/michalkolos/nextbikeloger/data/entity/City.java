package com.michalkolos.nextbikeloger.data.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITY_ID")
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
	@Column(name = "ZOOM")
	private int zoom;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "ALIAS")
	private String alias;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "NAME")
	private String name;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "NUM_PLACES")
	private int num_places;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "REFRESH_RATE")
	private int refresh_rate;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "BOUNDS")
	private String bounds;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "BOOKED_BIKES")
	private int booked_bikes;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "SET_POINT_BIKES")
	private int set_point_bikes;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "AVAILABLE_BIKES")
	private int available_bikes;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "RETURN_TO_OFFICIAL_ONLY")
	private int return_to_official_only;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "BIKE_TYPES")
	private String bike_types;

	@ManyToOne
	@JoinColumn
	private Country country;

	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private Set<Place> place = new HashSet<>();



	public boolean equals(Object o) {
		return (o instanceof City) && (((City)o).getUid() == this.getUid());
	}

	public int hashCode() {
		return this.getUid();
	}




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

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum_places() {
		return num_places;
	}

	public void setNum_places(int num_places) {
		this.num_places = num_places;
	}

	public int getRefresh_rate() {
		return refresh_rate;
	}

	public void setRefresh_rate(int refresh_rate) {
		this.refresh_rate = refresh_rate;
	}

	public String getBounds() {
		return bounds;
	}

	public void setBounds(String bounds) {
		this.bounds = bounds;
	}

	public int getBooked_bikes() {
		return booked_bikes;
	}

	public void setBooked_bikes(int booked_bikes) {
		this.booked_bikes = booked_bikes;
	}

	public int getSet_point_bikes() {
		return set_point_bikes;
	}

	public void setSet_point_bikes(int set_point_bikes) {
		this.set_point_bikes = set_point_bikes;
	}

	public int getAvailable_bikes() {
		return available_bikes;
	}

	public void setAvailable_bikes(int available_bikes) {
		this.available_bikes = available_bikes;
	}

	public int getReturn_to_official_only() {
		return return_to_official_only;
	}

	public void setReturn_to_official_only(int return_to_official_only) {
		this.return_to_official_only = return_to_official_only;
	}

	public String getBike_types() {
		return bike_types;
	}

	public void setBike_types(String bike_types) {
		this.bike_types = bike_types;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<Place> getPlace() {
		return place;
	}

	public void setPlace(Set<Place> place) {
		this.place = place;
	}
}
