package com.backpacker.springBoot.product.dao;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backpacker.springBoot.product.ProductVo;
import com.backpacker.springBoot.user.UserVo;
import com.backpacker.springBoot.user.dao.UserDao;

@Repository
public class ProductDao {

	private static final Logger log = LoggerFactory.getLogger(ProductDao.class);
	
	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 등록자 : 양한길
	 * 등록일 : 2021.12.09
	 * 단일 회원의 주문 목록 조회
	 * @param String
	 * @return ProductVo 
	 * @throws IOException
	 * @exception Exception
	 */
	public List<ProductVo> selectProductList(String F_EMAIL) {
		log.debug("getLogin");
		
		System.err.println(F_EMAIL);
		List<ProductVo> userOrder = sqlSession.selectList("product.selectProductList", F_EMAIL);
		System.out.println(userOrder.size());
		
		return userOrder;
	}
	
}
