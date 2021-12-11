package com.backpacker.springBoot.login;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.backpacker.springBoot.login.service.Loginservice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"로그인 API"})
public class LoginApi {
	
	@Autowired
	Loginservice loginService;

	@PostMapping(value = "/getlogin")
	@ResponseBody
	public Object login(
			@Valid LoginVo loginVo,
			BindingResult BindingResult,
			Locale locale,
			Model model,
			HttpSession session,
			HttpServletResponse response
		) throws IOException {
		
		ModelAndView mav = null;
		
		if(BindingResult.hasFieldErrors()) {
			String msg = BindingResult.getFieldError().getDefaultMessage();
			model.addAttribute("msg", msg);
			mav = new ModelAndView("main/login");
		} else {

			
			System.out.println(loginVo.getF_PASS());
			
			SessionVo sessionVo = loginService.getLogin(loginVo);
			
			if(sessionVo!=null) {
				session.setAttribute("userSession", sessionVo);
				response.sendRedirect("/userInfo");
			} else {
				model.addAttribute("msg", "비밀번호나 아이디가 맞지 않습니다");
				mav = new ModelAndView("main/login");
			}
		}
		return mav;
		
	}
	
	@PostMapping(value = "/logout")
	@ApiOperation(value = "로그아웃")
	public String logout(HttpSession session) {
		session.removeAttribute("userSession");
		return "redirect:/loginpage";
	}
}
