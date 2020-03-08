package com.michalkolos.nextbikeloger.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Weather implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="WEATHER_ID")
	private long id;

	@Column(name = "CONDITION_ID")
	private long condition_id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "TEMP")
	private double temp;

	@Column(name = "HUMAN_TEMP")
	private double human_temp;

	@Column(name = "PRESSURE")
	private int pressure;

	@Column(name = "HUMIDITY")
	private int humidity;

	@Column(name = "WIND_SPEED")
	private double wind_speed;

	@Column(name = "WIND_DEG")
	private int wind_deg;

	@Column(name = "CLOUDS")
	private int clouds;

	@Column(name = "VISIBILITY")
	private int visibility;

	@Column(name = "CALCULATED_TIME")
	private Timestamp calculatedTime;





	public boolean equals(Object o) {
		return (o instanceof Weather) && (((Weather)o).getCalculatedTime().equals(this.getCalculatedTime()));
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCondition_id() {
		return condition_id;
	}

	public void setCondition_id(long condition_id) {
		this.condition_id = condition_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getHuman_temp() {
		return human_temp;
	}

	public void setHuman_temp(double human_temp) {
		this.human_temp = human_temp;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}

	public int getWind_deg() {
		return wind_deg;
	}

	public void setWind_deg(int wind_deg) {
		this.wind_deg = wind_deg;
	}

	public int getClouds() {
		return clouds;
	}

	public void setClouds(int clouds) {
		this.clouds = clouds;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public Timestamp getCalculatedTime() {
		return calculatedTime;
	}

	public void setCalculatedTime(Timestamp calculated_time) {
		this.calculatedTime = calculated_time;
	}
}
