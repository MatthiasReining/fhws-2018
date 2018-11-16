package de.fhws.app.business.account.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(@NamedQuery(name = Account.FIND_BY_NAME, query = "Select a FROM Account a WHERE a.username = :"
		+ Account.PARAM_USERNAME))
@Entity
public class Account {

	public static final String FIND_BY_NAME = "Account.FindByName";
	public static final String PARAM_USERNAME = "Account_username";

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private Date lastLogin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
