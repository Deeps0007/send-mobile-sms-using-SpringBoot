package com.deeps.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@org.springframework.stereotype.Service("twilio")
public class TwilioSmsSender implements SmsSender {

	private final TwilioConfiguration twilioConfiguration;

	private static final Logger LOGGER=LoggerFactory.getLogger(TwilioSmsSender.class); 
	
	@Autowired
	public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
	}

	@Override
	public void sendSms(SmsRequest smsRequest) {

		if (isMobileNumberValid(smsRequest.getMobileNumber())) {

			PhoneNumber to = new PhoneNumber(smsRequest.getMobileNumber());
			PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrial_number());
			String msg = smsRequest.getMessage();
			MessageCreator creator=Message.creator(to, from, msg);
			creator.create();
			
			LOGGER.info("Send sms {} "+smsRequest);

		} else {
			new IllegalArgumentException(
					"Mobile Number [ " + smsRequest.getMobileNumber() + "] is not a Vallid Number");
		}

	}

	private boolean isMobileNumberValid(String mobileNumber) {
		return true;
	}

}
