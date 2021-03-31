package com.acn.google.workspacereservation.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acn.google.workspacereservation.entity.Accounts;

public interface AccountsRepo extends JpaRepository<Accounts, Integer>{
	boolean existsByEmail(String email);
	Optional<Accounts> getByEmail(String email);
}
