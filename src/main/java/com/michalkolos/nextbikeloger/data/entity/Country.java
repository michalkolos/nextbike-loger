package com.michalkolos.nextbikeloger.data.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRY")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COUNTRY_ID")
	private long id;

	@Column(name = "LAT")
	private double lat;
	@Column(name = "LNG")
	private double lng;
	@Column(name = "ZOOM")
	private int zoom;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DOMAIN")
	private String domain;
	@Column(name = "LANGUAGE")
	private String language;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "TIMEZONE")
	private String timezone;
	@Column(name = "CURRENCY")
	private String currency;
	@Column(name = "SYSTEM_OPERATOR_ADDRESS")
	private String system_operator_address;
	@Column(name = "BOOKED_BIKES")
	private int booked_bikes;
	@Column(name = "SET_POINT_BIKES")
	private int set_point_bikes;
	@Column(name = "AVAILABLE_BIKES")
	private int available_bikes;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private List<City> cities;



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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSystem_operator_address() {
		return system_operator_address;
	}

	public void setSystem_operator_address(String system_operator_address) {
		this.system_operator_address = system_operator_address;
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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
