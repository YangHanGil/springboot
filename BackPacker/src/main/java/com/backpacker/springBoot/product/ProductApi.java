package com.backpacker.springBoot.product;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backpacker.springBoot.product.service.ProductService;
import com.backpacker.springBoot.user.UserVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/product")
@Api(tags = {"상품조회 api"})
@RequiredArgsConstructor
public class ProductApi {
	
	@Autowired
	ProductService productService;

	@PostMapping(value = "/info")
	@ApiOperation(value = "단일 회원 상세 정보 조회", response = UserVo.class)
	public ResponseEntity<List<ProductVo>> selectUserInfo(String f_email){
		
		List<ProductVo> userOrder = productService.selectProductList(f_email);;
		
		HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<>(userOrder, header, HttpStatus.OK);
	}
}
