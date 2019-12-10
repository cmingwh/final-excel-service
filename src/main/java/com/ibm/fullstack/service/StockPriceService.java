package com.ibm.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fullstack.entity.StockPrice;
import com.ibm.fullstack.repository.StockPriceRepository;

@Service("stockPriceService")
public class StockPriceService {
	@Autowired
    StockPriceRepository stockPriceRepository;
	
	public Iterable<StockPrice> saveAll(List<StockPrice> data) {
		return stockPriceRepository.saveAll(data);
	}

}
