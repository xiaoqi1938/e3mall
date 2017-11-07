package cn.e3mall.manager.service;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.PageBeanResult;

public interface TBItemService {

	public TbItem findItemById(Long itemId);
	
	/**
	 * 需求：分页查询列表
	 * 参数：integer类型：page，rows
	 * 返回值：PageBeanResult
	 * */
	public PageBeanResult fingItemByPage(Integer page,Integer rows);
}
