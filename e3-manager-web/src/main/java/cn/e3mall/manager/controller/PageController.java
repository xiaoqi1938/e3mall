package cn.e3mall.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	
	/**
	 * 需求：实现页面跳转
	 * 参数：page(请求路径，字符串)
	 * 返回值：page(字符串)
	 * */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
