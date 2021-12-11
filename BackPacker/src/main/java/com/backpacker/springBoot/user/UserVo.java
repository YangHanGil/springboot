package com.backpacker.springBoot.user;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("user")
public class UserVo {

	private String F_EMAIL;   
	private String F_NAME;    
	private String F_NICKNAME;
	private String F_HP;      
	private String F_GENDER; 
	private String F_PRODUCT;
}
