package com.michalkolos.nextbikeloger.business.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public class DataDownloadService {

	public String download(String urlString) throws IOException {

		URL url = null;
		String rawXmlString = null;

		url = new URL(urlString);

		Scanner scanner = new Scanner(url.openStream(), StandardCharsets.UTF_8.toString());
		scanner.useDelimiter("\\A");
		rawXmlString = scanner.hasNext() ? scanner.next() : "";


		return  rawXmlString;
	}
}
