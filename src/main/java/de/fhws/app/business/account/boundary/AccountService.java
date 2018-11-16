package de.fhws.app.business.account.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhws.app.business.account.entity.Account;

@Stateless
public class AccountService {

	@PersistenceContext
	EntityManager em;

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
