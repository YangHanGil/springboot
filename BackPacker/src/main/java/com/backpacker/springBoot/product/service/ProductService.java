package com.backpacker.springBoot.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backpacker.springBoot.product.ProductVo;
import com.backpacker.springBoot.product.dao.ProductDao;

@Service
public class ProductService {
	
	private static final Logger log = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	ProductDao productDao;
	
	public List<ProductVo> selectProductList(String F_EMAIL){
		return productDao.selectProductList(F_EMAIL);
	}

}
