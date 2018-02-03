package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;

@RestController // 返回的是JSON格式
public class ItemController {
	
	// 注入service服务对象
	@Autowired
	private ItemService itemService;
	
	/**
	 * 需要：根据商品id查询商品数据
	 * 请求：item/{itemId}
	 * 参数：Long itemId
	 * 返回值： TbTtem
	 */
	@RequestMapping("item/{itemId}")
	public TbItem findItemById(@PathVariable Long itemId){
		TbItem item = itemService.findItemById(itemId);
		// 此时item返回的是JSON数据，因为使用了 RestController
		return item;
	}
}
