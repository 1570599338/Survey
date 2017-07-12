package com.lquan.business.question;

import java.util.List;

import com.lquan.entity.QueOption;
import com.lquan.entity.Question;

import net.sf.json.JSONObject;

public interface IQuestionServer {
	
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
	 * 转换器讲Json数据转换成Question
	 * @param json
	 * @return
	 */
	public  Question ConverterQuestion(JSONObject json,String userName);
	
	/**
	 * 讲Json数据转换成Bean
	 * @param json
	 * @param question
	 * @param userName
	 * @return
	 */
	public List<QueOption> ConverterQueOption(JSONObject json,Long question, String userName);
	
	/**
	 * 删除题目
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public Boolean deleteQuestion(JSONObject json) throws Exception;
	
	/**
	 *  调换题目的顺序
	 * @param id 第一个题目的ID
	 * @param dispIndex 第一个题目的序号
	 * @return
	 * @throws Exception
	 */
	public Boolean moveQuestion(Long id,int dispIndex) throws Exception;
	
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
