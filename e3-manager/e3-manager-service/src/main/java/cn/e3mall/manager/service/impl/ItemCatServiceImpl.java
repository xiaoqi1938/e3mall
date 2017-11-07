package cn.e3mall.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.e3mall.manager.service.ItemCatService;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.utils.EasyUITreeNode;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	/**
	 * 需求：查询商品类目表 参数：parentId 返回值：treeNode josn 格式数据：List
	 * <EasyUITreeNode> doubo：服务发布
	 */
	@Override
	public List<EasyUITreeNode> findItemCatList(Long parentId) {
		
		// 创建集合，封装树形列表
		List<EasyUITreeNode> treeList = new ArrayList<EasyUITreeNode>();
		
		// 根据父Id查询商品类别
		// 创建example对象:类似hibernate的qbc查询
		TbItemCatExample example = new TbItemCatExample();
		Criteria createCriteria = example.createCriteria();
		
		// 设置查询参数
		createCriteria.andParentIdEqualTo(parentId);
		
		// 查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		// 循环查询列表，封装节点信息
		for (TbItemCat tbItemCat : list) {
			
			// 创建EasyUITreeNode封装节点信息
			EasyUITreeNode treeNode = new EasyUITreeNode();
			// 设置节点Id
			treeNode.setId(tbItemCat.getId().intValue());
			// 设置节点名称
			treeNode.setText(tbItemCat.getName());
			// 设置节点状态，判断节点是否有子标题
			treeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
			treeList.add(treeNode);
		}
		
		return treeList;
	}

}
