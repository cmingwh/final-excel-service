package com.ibm.fullstack.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.fullstack.dto.StockPriceDto;
import com.ibm.fullstack.entity.StockPrice;
import com.ibm.fullstack.service.StockPriceService;
import com.ibm.fullstack.utils.ExcelUtils;
import com.ibm.fullstack.utils.Utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/excel")
@Api(value = "excel导入导出", tags = "excel导入导出", description = "excel导入导出")
public class ExcelController {
	private static final Logger logger = Logger.getLogger(FileController.class.getName());
    @Autowired
    StockPriceService stockPriceService;
//
//	  @ApiOperation(value = "导出")
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public void exportExcel()  throws IOException {
//        HttpServletResponse response = getHttpResponse();
//
//        List<BusClick> resultList = excelService.getBusClick();
//
//        long t1 = System.currentTimeMillis();
//        ExcelUtils.writeExcel(response, resultList, BusClick.class);
//        long t2 = System.currentTimeMillis();
//        System.out.println(String.format("write over! cost:%sms", (t2 - t1)));
//    }

	@ApiOperation(value = "导入")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public List<StockPrice> readExcel(MultipartFile file){
        long t1 = System.currentTimeMillis();
        List<StockPriceDto> list = ExcelUtils.readExcel("", StockPriceDto.class, file);
        long t2 = System.currentTimeMillis();
        logger.info(String.format("read over! cost:%sms", (t2 - t1)));
        List<StockPrice> data = Utils.convertToStockPrice(list);
        stockPriceService.saveAll(data);
        return data;
    }
}
