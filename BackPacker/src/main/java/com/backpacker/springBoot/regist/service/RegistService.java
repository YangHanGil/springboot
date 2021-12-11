package com.backpacker.springBoot.regist.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backpacker.springBoot.regist.RegistVo;
import com.backpacker.springBoot.regist.dao.RegistDao;

@Service
public class RegistService {

	
	private static final Logger log = LoggerFactory.getLogger(RegistService.class);
	
	@Autowired
	RegistDao registDao;
	
	public boolean insertUser(RegistVo registVo) {
		return registDao.insertUser(registVo);
	}

	public boolean selectUserFemail(String F_EMAIL) {
		return registDao.selectUserFemail(F_EMAIL);
	}
}
