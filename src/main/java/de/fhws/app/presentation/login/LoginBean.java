package de.fhws.app.presentation.login;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.fhws.app.business.account.boundary.AccountService;
import de.fhws.app.business.news.boundary.NewLogin;

@SessionScoped
@Named
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	@EJB
	AccountService account;

	@Inject
	@NewLogin
	Event<String> newLoginEvent;

	public String login() {

		boolean loginOkay = account.checkCredentials(username, password);

		if (loginOkay)
			newLoginEvent.fire("New on stage: " + username);

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
