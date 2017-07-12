package com.lquan.business.option;

public interface IOptionServer2 {
	
	/**
	 * 对选项进行排序
	 * @param firstID
	 * @param firstDispIndex
	 * @return
	 * @throws Exception
	 */
	public Boolean moveOPtion(Long firstID,int firstDispIndex) throws Exception;
	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public Boolean createOPtion(Object[] arg) throws Exception;
	
	/**
	 * 删除选项
	 * @param ID 选项的主键
	 * @return
	 * @throws Exception
	 */
	public Boolean deleteOption(Long ID) throws Exception;
	
	/**
	 * 更新选项的内容
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public Boolean updateOption(Object[] arg) throws Exception;

}
