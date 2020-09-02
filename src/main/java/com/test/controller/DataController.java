package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.DataService;

@Controller
@RequestMapping(value = "/data")
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@GetMapping("/check")
	public @ResponseBody ResponseEntity<Object> getDetails(
			@RequestParam(name = "RegistrationNumber",required = true) String registrationNo,
			@RequestParam(name="username",required = true) String username
			){
		String data = dataService.getData(registrationNo,username);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

}
