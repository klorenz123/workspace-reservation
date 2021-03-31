package com.acn.google.workspacereservation.service;

import java.util.List;

import com.acn.google.workspacereservation.entity.Accounts;

public interface AccountService {

	public List<Accounts> findAll();

	public Accounts findById(int theId);
	
	public Boolean findByEmail(String email);

	public Accounts getByEmail(String email);
	
	public void save(Accounts theClient);
	
	public void deleteById(int theId);

}
