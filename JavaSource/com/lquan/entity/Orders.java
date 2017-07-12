package com.lquan.entity;

/**
 * 排序
 * @author lquan
 *
 */
public class Orders {
	private Long id; // 题目的主键
	private int dispIndex;// 序号
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", dispIndex=" + dispIndex + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDispIndex() {
		return dispIndex;
	}
	public void setDispIndex(int dispIndex) {
		this.dispIndex = dispIndex;
	}
}
