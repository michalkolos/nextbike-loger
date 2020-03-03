package com.michalkolos.nextbikeloger.data.entity;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "COUNTRY")
public class Country{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRY_ID")
	private long id;

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
	@Column(name = "NAME")
	private String name;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "TIMEZONE")
	private String timezone;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "COUNTRY")
	private String country;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "COUNTRY_NAME")
	private String country_name;

	@Column(name = "BOOKED_BIKES")
	@JacksonXmlProperty(isAttribute = true)
	private int booked_bikes;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "SET_POINT_BIKES")
	private int set_point_bikes;

	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "AVAILABLE_BIKES")
	private int available_bikes;



	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private List<City> city = new ArrayList<>();




//	public boolean equals(Object o) {
//		return (o instanceof Country) && (((Country)o).getCountry()).equals(this.getCountry());
//	}
//
//	public int hashCode() {
//		return this.getCountry().hashCode();
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}
}
