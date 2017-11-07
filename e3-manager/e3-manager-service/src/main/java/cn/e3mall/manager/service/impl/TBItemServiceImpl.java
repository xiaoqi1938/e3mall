package cn.e3mall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.manager.service.TBItemService;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.utils.PageBeanResult;

@Service
public class TBItemServiceImpl implements TBItemService {
	
	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem findItemById(Long itemId) {
		return tbItemMapper.selectByPrimaryKey(itemId);
	}
	
	/**
	 * 需求：分页查询列表
	 * 参数：integer类型：page，rows
	 * 返回值：PageBeanResult
	 * 分页方法：使用pageHelper插件
	 * */
	@Override
	public PageBeanResult fingItemByPage(Integer page, Integer rows) {
		// 创建example对象
		TbItemExample example = new TbItemExample();
		
		//在查询之前,必须先设置分页
		PageHelper.startPage(page, rows);		
		//执行查询,自动分页查询,自动生成limit,count
		List<TbItem> list = tbItemMapper.selectByExample(example);
		
		//创建PageINfo对象,封装分页数据
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);

		// 创建分页返回值包装类对象
		PageBeanResult result = new PageBeanResult();

		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		return result;
	}

}
