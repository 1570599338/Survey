package com.lquan.web.controller.question;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lquan.business.question.IQuestionServer1;
import com.lquan.entity.Orders;
import com.lquan.entity.QueOption;
import com.lquan.entity.Question;
import com.lquan.web.util.JacksonJsonUtils;
import com.lquan.web.util.RespondSMSUtil;

@RestController
@RequestMapping("question")
public class QuestionManager {
	@Resource(name="questionServer1")
	public IQuestionServer1 questionServer;
	
	@RequestMapping(value = "/create")
    public @ResponseBody String createQuestion(@RequestParam String data) {
		System.out.println("*****add*****"+data);
		List<Question> objs = new ArrayList<Question>();
		List<Question> errors = new ArrayList<Question>();
		
		try {
			String user ="admin";
			// 转换题目
			Question question = JacksonJsonUtils.DeserializationObjectIgnoreUnkown(data, Question.class);
			List<QueOption> qolist = question.getOptions();
			
			Object[] arg = question.getObjectFile(); 
			arg[0] = question.getId();
			question = this.questionServer.createQuestion(question,user);
			objs.add(question);
			data = RespondSMSUtil.generateResponseContentByObject(objs, "", objs.size());
		} catch (Exception e) {
			e.printStackTrace();
			data =RespondSMSUtil.generateResponseContentByObject(objs, "",objs.size());
		}
		
		 return data;
    }
	 

	@RequestMapping(value = "/delete")
    public @ResponseBody String deleteQuestion(@RequestParam String data) {
		System.out.println("****del*****"+data);
		List<Question> objs = new ArrayList<Question>();
		List<Question> errors = new ArrayList<Question>();
		
		try {
			String user ="admin";
			// 转换题目
			Question question = JacksonJsonUtils.DeserializationObjectIgnoreUnkown(data, Question.class);
			List<QueOption> qolist = question.getOptions();
			
			Object[] arg = question.getObjectFile(); 
			arg[0] = question.getId();
			question = this.questionServer.deleteQuestion(question);
			objs.add(question);
			data = RespondSMSUtil.generateResponseContentByObject(objs, "", objs.size());
		} catch (Exception e) {
			e.printStackTrace();
			data =RespondSMSUtil.generateResponseContentByObject(objs, e,objs.size());
		}
		
			return data;
    }
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/move")
    public @ResponseBody String moveQuestion(@RequestParam String data) {
		System.out.println("****move*****"+data);
		List<Orders> objs = new ArrayList<Orders>();
		List<Object> errors = new ArrayList<Object>();
		
		try {
			String user ="admin";
			// 转换题目
			objs = JacksonJsonUtils.getStringCoverArrayList(data,Orders.class);
			objs = this.questionServer.moveQuestion(objs);
			
			data = RespondSMSUtil.generateResponseContentByObject(objs, "", objs.size());
		} catch (Exception e) {
			e.printStackTrace();
			errors.add(e);
			data =RespondSMSUtil.generateResponseContentByObject(objs, errors,objs.size());
		}
		
			return data;
    }
	
	
	/**
	 * 问卷题目的问题设置
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/updatetitle")
    public @ResponseBody String updateTitleQuestion(@RequestParam String data) {
		System.out.println("****updatetitle*****"+data);
		List<Question> objs = new ArrayList<Question>();
		List<Object> errors = new ArrayList<Object>();
		
		try {
			String user ="admin";
			// 转换题目
			Question question = JacksonJsonUtils.DeserializationObjectIgnoreUnkown(data,Question.class);
			question = this.questionServer.updateTitleQuestion(question);
			objs.add(question);
			
			data = RespondSMSUtil.generateResponseContentByObject(objs, "", objs.size());
		} catch (Exception e) {
			e.printStackTrace();
			errors.add(e);
			data =RespondSMSUtil.generateResponseContentByObject(objs, errors,objs.size());
		}
		
			return data;
    }
	
}
