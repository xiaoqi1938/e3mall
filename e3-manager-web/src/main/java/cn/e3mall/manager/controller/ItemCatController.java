package cn.e3mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.e3mall.manager.service.ItemCatService;
import cn.e3mall.utils.EasyUITreeNode;

@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * URL: /item/cat/list 
	 * 参数：parentId 前台 EasyUI 
	 * 框架传递参数名称是Id，使用注解：@requestParam（value=”id”）
	 * 返回值：json 格式 List<EasyUITreeNode>
	 * doubo：服务引用
	 */
	@RequestMapping("/item/cat/list")
	public @ResponseBody List<EasyUITreeNode> findItemCatList(@RequestParam(defaultValue = "0", value = "id") Long parentId){
		
		List<EasyUITreeNode> list = itemCatService.findItemCatList(parentId);
		System.out.println(list);
		return list;
	}

}
