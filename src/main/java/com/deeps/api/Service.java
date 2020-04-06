package com.deeps.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service()
public class Service {

	private SmsSender smsSender;

	@Autowired
	public Service(@Qualifier("twilio")SmsSender smsSender) {
		this.smsSender = smsSender;
	}
	
	public void sendSms(SmsRequest smsRequest) {
		smsSender.sendSms(smsRequest);
	}
	
	
}
