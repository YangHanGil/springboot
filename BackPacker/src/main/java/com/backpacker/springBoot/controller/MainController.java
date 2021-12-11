package com.backpacker.springBoot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.backpacker.springBoot.login.LoginVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@Api(tags = {"메인페이지변경"})
@RequiredArgsConstructor
public class MainController {
	
	static String root = "main/";
	
	@GetMapping(value = "/" )
	@ApiOperation(value = "로그인페이지")
	public ModelAndView login(
			Model model,
			HttpSession session
		) { 
		ModelAndView mav = new ModelAndView(root +"login");
		return mav;
	}

	@GetMapping(value = "/regist" )
	@ApiOperation(value = "회원가입페이지")
	public ModelAndView regist(
			Model model,
			HttpSession session
		) { 
		ModelAndView mav = new ModelAndView(root +"regist");
		return mav;
	}
}
