package com.backpacker.springBoot.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backpacker.springBoot.login.LoginVo;
import com.backpacker.springBoot.login.SessionVo;
import com.backpacker.springBoot.login.dao.LoginDao;

@Service
public class Loginservice {

	private static final Logger log = LoggerFactory.getLogger(Loginservice.class);
	
	@Autowired
	LoginDao loginDao;
	
	public SessionVo getLogin(LoginVo loginVo) {
		return loginDao.getLogin(loginVo);
	}
}
