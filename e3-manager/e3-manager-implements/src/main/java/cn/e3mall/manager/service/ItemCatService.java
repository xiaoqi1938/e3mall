package cn.e3mall.manager.service;

import java.util.List;

import cn.e3mall.utils.EasyUITreeNode;

public interface ItemCatService {

	/**
	 * 需求：查询商品类目表
	 * 参数：parentId
	 * 返回值：treeNode josn 格式数据：List<EasyUITreeNode>
	 * */
	public List<EasyUITreeNode> findItemCatList(Long parentId);
}
