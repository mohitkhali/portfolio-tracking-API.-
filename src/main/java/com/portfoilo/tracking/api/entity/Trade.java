package com.portfoilo.tracking.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "Ticker symbol",nullable = false)
	private String ticker;
	@Column(name = "Average Buy Price",nullable = false)
	private Float avg;
	@Column(name = "Shares",nullable = false)
	private Long shares;
	
	
}
