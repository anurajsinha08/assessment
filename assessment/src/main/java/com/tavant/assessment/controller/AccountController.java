package com.tavant.assessment.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.assessment.exception.AccountNotFoundException;
import com.tavant.assessment.exception.NoAccountFoundException;
import com.tavant.assessment.model.Account;
import com.tavant.assessment.service.AccountService;

@RestController
@RequestMapping("/api/account")

public class AccountController {

	@Autowired
	AccountService accountService;

	// To get all account details
	@GetMapping("/all")
	public Optional<List<Account>> getAccount() throws NoAccountFoundException {
		Optional<List<Account>> acc = accountService.getAccount();
		if (acc.get().size() == 0) {
			throw new NoAccountFoundException("No Account Data Exist");
		} else {
			return acc;
		}
	}

	// To get record of specific account
	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable("id") String accId) throws AccountNotFoundException {

		Optional<Account> acc = accountService.getAccountById(accId);

		if (acc.isPresent()) {
			return ResponseEntity.ok(acc.get());
		} else {
			throw new AccountNotFoundException("Account Details Not Found");
		}
	}

	// To insert data
	@PostMapping("/post") 
	public boolean addAccount(@RequestBody @Valid Account account) throws AccountNotFoundException {
		return accountService.addAccount(account);
	}

	// To delete account details
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") String accID) throws AccountNotFoundException {

		String acc = accountService.deleteAccount(accID);

		if (acc.equals("success")) {
			return ResponseEntity.ok(acc);
		} else {
			throw new AccountNotFoundException("Account to be deleted Not Found");
		}
	}

	// To update account details
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable("id") String accId, @RequestBody @Valid Account account)
			throws AccountNotFoundException {

		Optional<Account> acc = accountService.updateAccount(accId, account);

		if (acc.isPresent()) {
			return ResponseEntity.ok(acc.get());
		} else {
			throw new AccountNotFoundException("Account Details to be updated not Found");
		}
	}

}
