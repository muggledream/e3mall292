package cn.e3.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.e3.manager.service.ItemCatService;
import cn.e3.utils.TreeNode;

@RestController // 返回的是JSON格式
public class ItemCatController {
	
	// 注入服务对象,需要在注册中也引入
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 需求：根据parent_id 查询此节点的子节点
	 * 请求：/item/cat/list
	 * 参数：Longg parentId
	 * 返回值：json格式List<TreeNode>
	 * 业务：
	 * 	1.从初始化顶级树形节点，设置默认值为0
	 * 	2.它将会把节点id的值作为http请求参数并命名为'id'
	 */
	@RequestMapping("/item/cat/list")
	public List<TreeNode> findItemCatTreeNodeList(@RequestParam(defaultValue="0", value="id") Long parentId){
		// 调用远程商品类目服务方法
		List<TreeNode> list = itemCatService.findItemCatTreeNodeList(parentId);
		return list;
	}
}
