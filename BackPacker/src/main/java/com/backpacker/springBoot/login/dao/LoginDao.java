package com.backpacker.springBoot.login.dao;

import java.io.IOException;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backpacker.springBoot.login.LoginVo;
import com.backpacker.springBoot.login.SessionVo;

@Repository
public class LoginDao {

	private static final Logger log = LoggerFactory.getLogger(LoginDao.class);
	
	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 등록자 : 양한길
	 * 등록일 : 2021.12.08
	 * 로그인
	 * @param LoginVo
	 * @return SessionVo 
	 * @throws IOException
	 * @exception Exception
	 */
	public SessionVo getLogin(LoginVo loginVo) {
		log.debug("getLogin");
		
		SessionVo sessionVo = sqlSession.selectOne("login.login", loginVo);
		
		return sessionVo;
	}
}
