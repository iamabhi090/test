package com.test.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.test.datasource.DataSaver;
import com.test.proxy.ProxyServer;
import com.test.service.DataService;

@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	private DataSaver dataSource;
	
	@Autowired
	private ProxyServer proxyServer;

	@Override
	public String getData(String registrationNumber,String username) {
		String data = dataSource.getData(registrationNumber);
		if(!StringUtils.isEmpty(data)) {
			return data;
		}
		data = proxyServer.getData(registrationNumber,username);
		if(!StringUtils.isEmpty(data)) {
			dataSource.save(registrationNumber, data);
		}
		return data;
	}

}
