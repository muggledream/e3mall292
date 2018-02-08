package cn.e3.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3.manager.service.ItemCatService;
import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemCatExample.Criteria;
import cn.e3.utils.TreeNode;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	// 注入商品类目mapper接口代理对象
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	/**
	 * 需求：根据parent_id 查询此节点的子节点
	 * 参数：Long parentId
	 * 返回值：List<TreeNode>
	 */
	public List<TreeNode> findItemCatTreeNodeList(Long parentId){
		
		// 创建树形节点的集合,封装树形节点的值
		List<TreeNode> nodeList = new ArrayList<>();
		
		// 创建商品类目的example对象
		TbItemCatExample example = new TbItemCatExample();
		// 创建criteria对象，设置查询参数
		Criteria createCriteria = example.createCriteria();
		// 设置查询参数
		createCriteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		// 遍历商品类目的集合,把商品类目数据封装树形节点中
		for (TbItemCat tbItemCat : list) {
			
			// 创建属性节点对象 TreeNode,封装树形节点的值
			TreeNode node  = new TreeNode();
			
			// 封装树形节点的id
			node.setId(tbItemCat.getId());
			// 设置树节点名称
			node.setText(tbItemCat.getName());
			// 设置树节点状态
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			 
			// 把节点对象放入节点集合
			nodeList.add(node);
		}
		
		return nodeList;
	}
}
