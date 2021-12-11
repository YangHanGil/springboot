package com.backpacker.springBoot.user.dao;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backpacker.springBoot.Common.PageVo;
import com.backpacker.springBoot.user.UserVo;

@Repository
public class UserDao {

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 등록자 : 양한길
	 * 등록일 : 2021.12.09
	 * 단일 회원 상세 정보 조회
	 * @param String
	 * @return UserVo 
	 * @throws IOException
	 * @exception Exception
	 */
	public UserVo selectUserInfo(String F_EMAIL) {
		log.debug("getLogin");
		
		UserVo user = sqlSession.selectOne("user.selectUserInfo", F_EMAIL);
		
		return user;
	}
	
	/**
	 * 등록자 : 양한길
	 * 등록일 : 2021.12.11
	 * 회원리스트 조회
	 * @param PageVo
	 * @return List<UserVo> 
	 * @throws IOException
	 * @exception Exception
	 */
	public List<UserVo> selectUserList(PageVo pageVo) {
		log.debug("getLogin");
		
		List<UserVo> list = sqlSession.selectList("user.selectUserList", pageVo);
		
		return list;
	}
	

	/**
	 * 등록자 : 양한길
	 * 등록일 : 2021.12.11
	 * 회원리스트 조회 페이징
	 * @param PageVo
	 * @return int
	 * @throws IOException
	 * @exception Exception
	 */
	public int selectUserListCnt(PageVo pageVo) {
		log.debug("getLogin");
		
		int cnt = sqlSession.selectOne("user.selectUserListCnt", pageVo);
		
		return cnt;
	}

}
