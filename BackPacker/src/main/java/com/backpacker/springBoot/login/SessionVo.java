package com.backpacker.springBoot.login;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//세션관리 vo
@Getter
@Setter
@Alias("session")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionVo {

	private String F_EMAIL;
	private String F_NAME;
	private String F_NICKNAME;
}
