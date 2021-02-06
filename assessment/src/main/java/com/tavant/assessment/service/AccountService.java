package com.tavant.assessment.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.tavant.assessment.model.Account;

public interface AccountService {
	
	public boolean addAccount(Account account);
	public Optional<Account> updateAccount(String empID, Account account);
	public String deleteAccount(String accId);
	public Optional<Account> getAccountById(String accID);
	public Optional<List<Account>> getAccount();
		
}
