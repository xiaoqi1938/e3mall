package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.manager.service.TBItemService;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.PageBeanResult;

@Controller
public class TBItemController {

	@Autowired
	private TBItemService tBItemService;
	
	@RequestMapping("/item/findItem/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable Long itemId) throws Exception{
		return tBItemService.findItemById(itemId);
	}
	
	/**
	 * 需求：分页查询列表
	 * 参数：integer类型：page，rows
	 * 返回值：Json：PageBeanResult
	 * */
	@RequestMapping("/item/list")
	@ResponseBody
	public PageBeanResult findItemByPage(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="20")Integer rows){
		
		PageBeanResult result  = tBItemService.fingItemByPage(page, rows);
		
		return result ;
	} 
}
