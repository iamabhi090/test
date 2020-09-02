package com.test.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.entity.Data;
import com.test.repository.DataSourceRepository;

@Component
public class DataSaver {
	
	@Autowired
	private DataSourceRepository dataSourceRepository;
	
	public String getData(String registrationNo) {
		Data data = dataSourceRepository.findByRegistrationNo(registrationNo);
		if(data==null) {
			return null;
		}
		return data.getData();
	}
	
	public void save(String registrationNo,String data) {
		Data dataE = new Data();
		dataE.setData(data);
		dataE.setRegistrationNumber(registrationNo);
		dataSourceRepository.save(dataE);
		return;
	}

}
