package de.fhws.app.presentation.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import de.fhws.app.business.account.boundary.AccountService;
import de.fhws.app.business.account.boundary.CurrentUser;
import de.fhws.app.business.account.entity.Account;
import de.fhws.app.business.news.boundary.NewLogin;

@SessionScoped
@Named
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	private Account loggedInUser;

	@Inject
	AccountService account;

	@Inject
	@NewLogin
	Event<String> newLoginEvent;

	public String login() {

		loggedInUser = account.checkCredentials(username, password);
		boolean loginOkay = loggedInUser == null ? false : true;

		if (loginOkay)
			newLoginEvent.fire("New on stage: " + username);

		return loginOkay ? "student-list?faces-redirect=true" : "";
	}

	@Produces
	@CurrentUser
	@SessionScoped
	@Named
	public Account getCurrentUser() {
		return loggedInUser;
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
