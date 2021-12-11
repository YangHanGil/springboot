package com.backpacker.springBoot.regist;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.backpacker.springBoot.regist.service.RegistService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/regist")
@Api(tags = {"회원가입 API"})
@RequiredArgsConstructor
public class RegistApi {
	
	@Autowired
	RegistService registService;

	@PostMapping(value = "/insertUser")
	@ApiOperation(value = "회원가입", response = RegistVo.class)
	public Object insertUser(
			@Valid RegistVo registVo,
			BindingResult BindingResult,
			Model model
		) {
		
		ModelAndView mav;

		boolean res = false;
		if(registService.selectUserFemail(registVo.getF_EMAIL())) {
			
			if(BindingResult.hasFieldErrors()) {
				String msg = BindingResult.getFieldError().getDefaultMessage();
				model.addAttribute("msg", msg);
				mav = new ModelAndView("main/regist");
				return mav;
			} else {
					res = registService.insertUser(registVo);
					if (res) {
						model.addAttribute("msg", "회원가입에 성공하셨습니다. 로그인하시기 바랍니다.");
						mav = new ModelAndView("main/login");
					} else {
						mav = new ModelAndView("main/regist");
					}
				return mav;
			}
		} else {
			model.addAttribute("msg", "아이디중복");
			mav = new ModelAndView("main/regist");
		}
		return mav;
		
	}
	

	@RequestMapping(value="/selectUserFemail", method = {RequestMethod.POST})
	@ApiOperation(value = "조회", response = RegistVo.class)
	public boolean selectUserFemail(
			String F_EMAIL
		) {
		
		
		boolean res = registService.selectUserFemail(F_EMAIL);
		System.out.println(res);
		return res;
	}
    
 }
