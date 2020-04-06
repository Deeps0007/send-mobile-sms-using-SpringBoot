package com.deeps.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitialzer {

	private final static Logger LOGGER=LoggerFactory.getLogger(TwilioInitialzer.class);
	
	private  final TwilioConfiguration twilioConfiguration;

	@Autowired
	public TwilioInitialzer(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
		
		Twilio.init(twilioConfiguration.getAccount_sid(), twilioConfiguration.getAuth_token());
		LOGGER.info("Twilio intialize with..Account {} ",twilioConfiguration.getAccount_sid());
	}
	
	
	
	
	
}
