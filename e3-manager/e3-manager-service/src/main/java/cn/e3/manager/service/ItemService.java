package cn.e3.manager.service;

import cn.e3.pojo.TbItem;

public interface ItemService {

	/**
	 * 需要：根据商品id查询商品数据
	 * 参数：Long itemId
	 * 返回值： TbTtem
	 */
	public TbItem findItemById(Long itemId);
}
