package com.backpacker.springBoot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.backpacker.springBoot.Common.PageVo;
import com.backpacker.springBoot.login.LoginVo;
import com.backpacker.springBoot.login.SessionVo;
import com.backpacker.springBoot.product.ProductVo;
import com.backpacker.springBoot.product.service.ProductService;
import com.backpacker.springBoot.user.UserVo;
import com.backpacker.springBoot.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@Api(tags = {"회원페이지변경"})
@RequiredArgsConstructor
public class UserController {

	static String root = "user/";

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/userInfo" )
	@ApiOperation(value = "회원정보상세페이지")
	public ModelAndView userInfo(
			String F_EMAIL,
			Model model,
			HttpSession session
		) { 
		ModelAndView mav = new ModelAndView(root +"userInfo");
		
		SessionVo sessionVo = (SessionVo)session.getAttribute("userSession");
		if(F_EMAIL==null) {
			F_EMAIL = sessionVo.getF_EMAIL();
		}
		
		UserVo userVo = userService.selectUserInfo(F_EMAIL);
		model.addAttribute("userVo", userVo);
		
		List<ProductVo> userOrder = productService.selectProductList(F_EMAIL);;
		model.addAttribute("userOrder", userOrder);
		
		return mav;
	}

	@GetMapping(value = "/userList" )
	@ApiOperation(value = "회원목록페이지")
	public ModelAndView userList(
			Model model,
			HttpSession session,
			@RequestParam(required = false, defaultValue = "1") int nowPage, 
			@RequestParam(required = false, defaultValue = "1") int cntPerPage, 
			@RequestParam(required = false, defaultValue = "10") int lastList,
			String board_selec, 
			String boardSearch, 
			String search
		) { 

		String f_board_div = "1";
		PageVo pageVo = new PageVo();
		pageVo.setF_board_div(f_board_div);
		pageVo.setBoard_selec(board_selec);
		pageVo.setBoardSearch(boardSearch);
		pageVo.setLastList(lastList);
		pageVo.setListSize(lastList);

		int cnt = userService.selectUserListCnt(pageVo);
		pageVo.pageInfo(nowPage, cntPerPage, cnt);
		model.addAttribute("pageVo", pageVo);
		List<UserVo> userList = userService.selectUserList(pageVo);
		
		model.addAttribute("list", userList);
		model.addAttribute("cnt", cnt);
		model.addAttribute("board_selec", board_selec);
		model.addAttribute("boardSearch", boardSearch);
		
		ModelAndView mav = new ModelAndView(root +"userList");
		return mav;
	}

	@GetMapping(value = "/userProDuctList" )
	@ApiOperation(value = "회원주문목록페이지")
	public ModelAndView userProDuctList(
			Model model,
			HttpSession session
		) { 
		ModelAndView mav = new ModelAndView(root +"userProDuctList");
		return mav;
	}
}
