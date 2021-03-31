package com.acn.google.workspacereservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acn.google.workspacereservation.entity.Accounts;
import com.acn.google.workspacereservation.repo.AccountsRepo;

@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountsRepo accountsRepo;
	
	@Autowired
	public AccountServiceImpl(AccountsRepo theAccountsRepo) {
		accountsRepo = theAccountsRepo;
	}
	
	@Override
	public List<Accounts> findAll() {
		return accountsRepo.findAll();
	}

	@Override
	public Accounts findById(int theId) {
		Optional<Accounts> result = accountsRepo.findById(theId);
		
		Accounts theclients = null;
		
		if (result.isPresent()) {
			theclients = result.get();
		}
		else {
			throw new RuntimeException("Did not find client id - " + theId);
		}
		
		return theclients;
	}

	@Override
	public void save(Accounts theClient) {
		accountsRepo.save(theClient);
	}

	@Override
	public void deleteById(int theId) {
		accountsRepo.deleteById(theId);
	}

	@Override
	public Boolean findByEmail(String email) {
		return accountsRepo.existsByEmail(email);
	}

	@Override
	public Accounts getByEmail(String email) {
		Optional<Accounts> result = accountsRepo.getByEmail(email);
		
		Accounts theclients = null;
		
		if (result.isPresent()) {
			theclients = result.get();
		}
		
		return theclients;
	}


}
