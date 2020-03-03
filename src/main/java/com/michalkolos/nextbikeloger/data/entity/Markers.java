package com.michalkolos.nextbikeloger.data.entity;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JacksonXmlRootElement(localName = "markers")
public class Markers implements Serializable {

	@JacksonXmlProperty(localName = "country")
	private List<Country> country = new ArrayList<>();

	public List<Country> getCountry() {
		return country;
	}


	public void setCountry(List<Country> country) {
		this.country = country;
	}
}
