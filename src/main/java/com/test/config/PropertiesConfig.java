package com.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {
	
	@Value("${proxy.server.url}")
	private String url;
	
	@Value("${proxy.server.username}")
	private String userName;
	
	@Value("${proxy.server.password}")
	private String password;

	public String getUrl() {
		return url;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	
}
