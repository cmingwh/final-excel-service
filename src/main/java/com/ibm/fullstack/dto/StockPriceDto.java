package com.ibm.fullstack.dto;

import java.util.Date;

import com.ibm.fullstack.entity.ExcelColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDto {
	private Long id;

	@ExcelColumn(value = "Company Code", col = 1)
	private String companyCode;

	@ExcelColumn(value = "Stock Exchange", col = 2)
	private String stockExchange;

	@ExcelColumn(value = "Price Per Share(in Rs)", col = 3)
	private Double price;
	
	@ExcelColumn(value = "Date", col = 4)
	private Date happenDate;
	
	@ExcelColumn(value = "Time", col = 5)
	private String happenTime;
}
