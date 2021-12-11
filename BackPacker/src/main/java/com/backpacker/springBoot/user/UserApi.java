package com.backpacker.springBoot.user;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backpacker.springBoot.regist.RegistVo;
import com.backpacker.springBoot.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/user")
@Api(tags = {"회원정보 API"})
@RequiredArgsConstructor
public class UserApi {

	@Autowired
	UserService userService;
	
	@PostMapping(value = "/info")
	@ApiOperation(value = "단일 회원 상세 정보 조회", response = UserVo.class)
	public ResponseEntity<UserVo> selectUserInfo(String f_email){
		
		UserVo userVo = userService.selectUserInfo(f_email);
		
		HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<>(userVo, header, HttpStatus.OK);
	}
}
