package com.sankar.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sankar.tech.entity.Transaction;
import com.sankar.tech.repository.TransactionRepository;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionRepository repository;
	
	
	@PostMapping
	public Transaction saveTransaction(@RequestBody Transaction transaction)
	{
		return repository.save(transaction);
	}
	
	@GetMapping
	public List<Transaction> getAllTransactionDetails()
	{
		return repository.findAll();
	}

}
