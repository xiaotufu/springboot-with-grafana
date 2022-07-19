package com.xiaotugo.controller;

import cn.hutool.http.HttpUtil;
import com.xiaotugo.constant.Constants;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author karl
 */
@RestController
@RequestMapping("/")
@Slf4j
public class BankController {
	/**
	 * 获取银行LOGO
	 * @param req 银行卡类型
	 * @return
	 */
	@SneakyThrows
	@GetMapping("/card/{cardNo}")
	public String getCardInfo(@PathVariable("cardNo") String req) {
		String resp = HttpUtil.get(String.format(Constants.API_CARD_INFO, req));
		//模拟业务耗时
		Thread.sleep(200);
		if(log.isInfoEnabled()){
			log.info("{银行卡[{}],对应详细信息为{}",req,resp);
		}
		return resp;
	}
}
