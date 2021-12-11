package com.backpacker.springBoot.regist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;

import com.backpacker.springBoot.Common.RegExp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistVo {
		
	//이메일
	@NotBlank(message = "이메일을 입력하여 주십시오")
	@Size(max = 100, message = "이메일은 최대 100자까지 가능합니다.")
	@Pattern(
		regexp="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$"
		,message = "이메일형식을 맞춰주시기 바랍니다."
	)
	private String F_EMAIL;
	
	
	//이름
	@NotBlank(message = "이름을 입력하여 주십시오")
	@Size(max = 20, message = "이름은 최대 20자까지 가능합니다.")
	@Pattern(
		regexp="^[a-zA-Z가-힣]*$"
		,message = "이름은 영문 대소문자 및 한글만 가능합니다"
	)
	private String F_NAME;
	
	
	//별명
	@NotBlank(message = "별명을 입력하여 주십시오")
	@Size(max = 30, message = "별명은 최대 30자까지 가능합니다.")
	@Pattern(
		regexp="^[a-z]*$"
		,message = "별명은 영문 소문자만 사용 가능합니다"
	)
	private String F_NICKNAME;
	
		
	//비밀번호
	@NotBlank(message = "비밀번호를 입력하여 주십시오")
	@Pattern(
		regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{10,100}$"
		,message = "비밀번호는 영문대소문자 및 숫자, 특수문자만 10자이상 사용 가능합니다."
	)
	private String F_PASS;
	
		
	//전화번호
	@NotBlank(message = "전화번호를 입력하여 주십시오")
	@Size(max = 20, message = "전화번호는 최대 20자까지 가능합니다.")
	@Pattern(
		regexp="^[0-9]*$"
		,message = "전화번호는 숫자만 입력하여 주십시오"
	)
	
	@Size(max = 20, message = "전화번호는 최대 20자까지 가능합니다.")
	private String F_HP;
	
	private String F_GENDER;
}
