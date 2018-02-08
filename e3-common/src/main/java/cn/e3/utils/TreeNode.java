package cn.e3.utils;

import java.io.Serializable;

public class TreeNode implements Serializable {

	// 树节点id
	private Long id;
	// 树节点名称
	private String text;
	
	// 树节点状态
	// 当 is_parent = 1,表示此节点有子节点,state="closed",处于可打开状态
	// 当 is_parent = 0,表示此节点没有子节点,state="open",表示已经是最后一级节点，不能再打开了
	private String state;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
