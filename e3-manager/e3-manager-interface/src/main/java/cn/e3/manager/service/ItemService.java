package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.utils.PageResult;

public interface ItemService {

	/**
	 * 需要：根据商品id查询商品数据
	 * 参数：Long itemId
	 * 返回值： TbTtem
	 */
	public TbItem findItemById(Long itemId);
	
	/**
	 * 需求：商品列表，进行分页查询
	 * 参数：Integer page, Integer rows
	 * 返回值：PageResult
	 */
	public PageResult findItemListByPage(Integer page, Integer rows);
}
