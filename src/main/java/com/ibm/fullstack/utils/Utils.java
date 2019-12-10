package com.ibm.fullstack.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ibm.fullstack.dto.StockPriceDto;
import com.ibm.fullstack.entity.StockPrice;

public class Utils {
	public static String getJwtFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer")) {
            return token.replace("Bearer ", "");
        }
        return null;
    }
	
	public static StockPrice convertToStockPrice(StockPriceDto priceDto) {
		if(null == priceDto.getPrice() || null == priceDto.getStockExchange() || null == priceDto.getCompanyCode()) {
			return null;
		}
		StockPrice price = new StockPrice();
		price.setCompanyCode(priceDto.getCompanyCode());
		price.setPrice(priceDto.getPrice());
		price.setStockExchange(priceDto.getStockExchange());
		Date happenTime = concatDate(priceDto.getHappenDate(), priceDto.getHappenTime());
		price.setHappenTime(happenTime);
		return price;
	}

	public static List<StockPrice> convertToStockPrice(List<StockPriceDto> priceDtoList) {
		List<StockPrice> priceList = new ArrayList<StockPrice>();
		Iterator<StockPriceDto> it = priceDtoList.iterator();
		while(it.hasNext()) {
			StockPrice price = convertToStockPrice(it.next());
			if(null != price) {
				priceList.add(price);
			}
		}
		return priceList;
	}
	
	private static Date concatDate(Date happenDate, String happenTime) {
		SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			
			return yyyyMMddHHmmss.parse(yyyyMMdd.format(happenDate) + " " + happenTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
