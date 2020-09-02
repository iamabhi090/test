package com.test.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.config.PropertiesConfig;

@Service
public class ProxyServer {
	
	@Autowired
	private PropertiesConfig propertiesConfig;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getData(String registrationNumber,String username) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_XML_VALUE);
		String userName = username!=null?username:propertiesConfig.getUserName();
		String url = propertiesConfig.getUrl();

		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("RegistrationNumber", registrationNumber)
		        .queryParam("username", userName);
		
		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		return response.getBody();
	}

}
