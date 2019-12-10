package com.ibm.fullstack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.fullstack.entity.StockPrice;

@Repository
public interface StockPriceRepository  extends CrudRepository<StockPrice, Long> {

}
