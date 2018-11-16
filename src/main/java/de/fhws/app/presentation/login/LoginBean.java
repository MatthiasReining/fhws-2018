package de.fhws.app.presentation.login;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.fhws.app.business.account.boundary.AccountService;

@SessionScoped
@Named
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	@EJB
	AccountService account;

	public String login() {

		boolean loginOkay = account.checkCredentials(username, password);

		return loginOkay ? "student-list?faces-redirect=true" : "";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
