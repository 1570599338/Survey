package com.lquan.business.question;

import java.util.List;

import com.lquan.entity.Orders;
import com.lquan.entity.QueOption;
import com.lquan.entity.Question;

import net.sf.json.JSONObject;

public interface IQuestionServer1 {
	
	/**
	 * 创建并返回数据
	 * @param question
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Question createQuestion(Question question,String user) throws Exception;
	
	/**
	 * 删除题目
	 * @param question
	 * @return
	 * @throws Exception
	 */
	public Question deleteQuestion(Question question) throws Exception;
	
	/**
	 *  调换题目的顺序
	 * @param id 第一个题目的ID
	 * @param dispIndex 第一个题目的序号
	 * @return
	 * @throws Exception
	 */
	public List<Orders> moveQuestion(List<Orders> objs) throws Exception;
	
	
	/**
	 * 设置题目的问题
	 * @param question
	 * @return
	 * @throws Exception
	 */
	public Question updateTitleQuestion(Question question) throws Exception;
	
	/**
	 * 插入题目
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public Boolean createQuestion(Object[] arg) throws Exception;
	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public Boolean createOPtion(Object[] arg) throws Exception;
	
	

	/**
	 * 获取问卷所有数据
	 * @param id 问卷的ID
	 * @return
	 * @throws Exception
	 */
	public List<Question> searchQuestionList(Long id) throws Exception;
	
	/**
	 * 获取问卷的选项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<QueOption> getQueOption(Long id) throws Exception;
	
	/**
	 * 题目的题目的相关的设置
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	public Boolean updateQuestion(Object[] arg) throws Exception;
}
