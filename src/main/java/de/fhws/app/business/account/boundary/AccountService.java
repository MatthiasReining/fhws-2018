package de.fhws.app.business.account.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhws.app.business.account.entity.Account;
import de.fhws.app.business.log.boundary.LogService;

@Stateless
public class AccountService {

	@PersistenceContext
	EntityManager em;

	@Inject
	LogService logService;

	public Account checkCredentials(String username, String password) {

		List<Account> accounts = em.createNamedQuery(Account.FIND_BY_NAME, Account.class)
				.setParameter(Account.PARAM_USERNAME, username).getResultList();

		if (accounts.size() != 1)
			return null;

		Account account = accounts.get(0);

		if (!account.getPassword().equals(password))
			return null;

		logService.log(username + " logged in");
		return account;
	}

	public List<Account> getAccounts() {
		return null;
	}
}
