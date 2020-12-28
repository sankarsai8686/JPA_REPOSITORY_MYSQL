package com.sankar.tech.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tranlog")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@IdClass(TransactionPK.class)
public class Transaction {
	
	/*@Id
	private long txnId;
	@Id
	private long merchTrackId;*/
	
	@EmbeddedId 
	TransactionPK transactionPK;
	
	//Requirement is maintina txnId & merchTrackId both as primary key use concept
	//as composite key
	
	
	private String type;
	private double amount;
	
	

}
