package com.sankar.tech.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TransactionPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long txnId;
	private long merchTrackId;
}
