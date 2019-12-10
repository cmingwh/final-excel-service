package com.ibm.fullstack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock_price", schema = "fullstack")
public class StockPrice {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "company_code")
	private String companyCode;

	@Column(name = "stock_exchange")
	private String stockExchange;

	@Column(name = "price")
	private Double price;
	
	@Column(name = "happen_time")
	private Date happenTime;
}
