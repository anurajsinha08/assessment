package com.tavant.assessment.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.assessment.model.Account;
import com.tavant.assessment.repository.AccountRepository;

@Service

public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public boolean addAccount(Account account) {
		Account acc = accountRepository.save(account);
		// This save method will help to insert record to a table
		return acc != null;
	}

	@Override
	public Optional<Account> updateAccount(String empID, Account account) {
		Optional<Account> acc = accountRepository.findById(empID);
		if (acc.isPresent()) {
			Account update = acc.get();
			update.setAccountId(account.getAccountId());
			update.setAccountNumber(account.getAccountNumber());
			update.setAccountType(account.getAccountType());
			update.setAddress(account.getAddress());
			update.setBalance(account.getBalance());
			update.setEmail(account.getEmail());
			update.setFirstName(account.getFirstName());
			update.setLastName(account.getLastName());

			final Account newDetails = accountRepository.save(update);
			return Optional.ofNullable(newDetails);
		}

		return null;
	}

	@Override
	public String deleteAccount(String accId) {
		if (accountRepository.existsById(accId)) {
			accountRepository.deleteById(accId);
			return "success";
		}
		return "fail";
	}

	@Override
	public Optional<Account> getAccountById(String accID) {
		return accountRepository.findById(accID);
	}

	@Override
	public Optional<List<Account>> getAccount() {
		return Optional.ofNullable(accountRepository.findAll());
	}

}
