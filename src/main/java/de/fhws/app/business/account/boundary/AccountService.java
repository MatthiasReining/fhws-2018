package de.fhws.app.business.account.boundary;

import java.util.List;

import javax.persistence.EntityManager;

import de.fhws.app.business.account.entity.Account;

public class AccountService {

	EntityManager em;

	public AccountService(EntityManager em) {
		this.em = em;
	}

	public boolean checkCredentials(String username, String password) {

		List<Account> accounts = em.createNamedQuery(Account.FIND_BY_NAME, Account.class)
				.setParameter(Account.PARAM_USERNAME, username).getResultList();

		if (accounts.size() != 1)
			return false;

		Account account = accounts.get(0);

		if (account.getPassword().equals(password))
			return true;
		return false;
	}

	public List<Account> getAccounts() {
		return null;
	}
}
