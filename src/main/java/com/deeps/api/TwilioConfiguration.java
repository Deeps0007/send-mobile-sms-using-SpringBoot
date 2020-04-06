package com.deeps.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {
	
	
	private String account_sid;
	private String auth_token;
	private String trial_number;
	
	
	
	public TwilioConfiguration() {
	}
	
	
	public String getAccount_sid() {
		return account_sid;
	}
	public void setAccount_sid(String account_sid) {
		this.account_sid = account_sid;
	}
	public String getAuth_token() {
		return auth_token;
	}
	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}
	public String getTrial_number() {
		return trial_number;
	}
	public void setTrial_number(String trial_number) {
		this.trial_number = trial_number;
	}
	
	

}
