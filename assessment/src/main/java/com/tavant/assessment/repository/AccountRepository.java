package com.tavant.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.assessment.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
