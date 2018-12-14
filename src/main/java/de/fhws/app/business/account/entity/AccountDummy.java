package de.fhws.app.business.account.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountDummy {

	
	public String univerity;
	public String course;
	
	public AccountDummy(String univerity, String course) {
		super();
		this.univerity = univerity;
		this.course = course;
	}
	
	public AccountDummy() {
		//empty constructor
	}
}
