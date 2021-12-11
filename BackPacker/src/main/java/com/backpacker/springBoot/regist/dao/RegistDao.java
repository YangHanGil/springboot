package com.backpacker.springBoot.regist.dao;

import java.io.IOException;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backpacker.springBoot.regist.RegistVo;

@Repository
public class RegistDao {

	private static final Logger log = LoggerFactory.getLogger(RegistDao.class);
	
	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 등록자 : 양한길
	 * 등록일 : 2021.12.08
	 * 회원가입
	 * @param RegistVo
	 * @return boolean 
	 * @throws IOException
	 * @exception Exception
	 */
	public boolean insertUser(RegistVo registVo) {
		boolean res = false;
		try {
			int cnt = sqlSession.insert("regist.insertUser", registVo);
			res = cnt>0? true:false;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("insertUser : error" + e);
		}
		return res;
	}
	
	/**
	 * 등록자 : 양한길
	 * 등록일 : 2021.12.11
	 * 아이디중복찾기
	 * @param String
	 * @return boolean 
	 * @throws IOException
	 * @exception Exception
	 */
	public boolean selectUserFemail(String F_EMAIL) {
		boolean res = false;
		try {
			String data = sqlSession.selectOne("regist.selectUserFemail", F_EMAIL);
			res = data==null? true:false;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("insertUser : error" + e);
		}
		return res;
	}
}
