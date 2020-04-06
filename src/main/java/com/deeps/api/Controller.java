package com.deeps.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("smsapi")
public class Controller {

	private Service service;

	@Autowired
	public Controller(Service service) {
		this.service = service;
	}
	
	@PostMapping("/send")
	public void sendSms(@RequestBody SmsRequest smsRequest) {
		service.sendSms(smsRequest);
	}
	
	
}
