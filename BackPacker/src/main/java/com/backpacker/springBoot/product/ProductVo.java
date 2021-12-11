package com.backpacker.springBoot.product;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("userOrder")
public class ProductVo {

	private String F_NUM;
	private String F_NAME;
	private String F_PAY_DATE;
}
