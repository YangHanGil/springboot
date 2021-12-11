package com.backpacker.springBoot.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backpacker.springBoot.Common.PageVo;
import com.backpacker.springBoot.user.UserVo;
import com.backpacker.springBoot.user.dao.UserDao;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;
	
	public UserVo selectUserInfo(String F_EMAIL) {
		return userDao.selectUserInfo(F_EMAIL);
	}
	
	public List<UserVo> selectUserList(PageVo pageVo) {
		return userDao.selectUserList(pageVo);
	}

	public int selectUserListCnt(PageVo pageVo) {
		return userDao.selectUserListCnt(pageVo);
	}
}
