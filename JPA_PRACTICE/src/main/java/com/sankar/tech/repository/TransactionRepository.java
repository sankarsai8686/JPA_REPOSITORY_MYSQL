package com.sankar.tech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sankar.tech.entity.Transaction;
import com.sankar.tech.entity.TransactionPK;

//public interface TransactionRepository extends JpaRepository<Transaction, Long>{
public interface TransactionRepository extends JpaRepository<Transaction, TransactionPK>{

	List<Transaction> findByAmount(double amount);
	
}
