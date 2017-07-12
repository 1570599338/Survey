package com.lquan.web.controller.question;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lquan.business.question.IQuestionServer;
import com.lquan.business.question.IQuestionServer1;
import com.lquan.entity.Orders;
import com.lquan.entity.QueOption;
import com.lquan.entity.Question;
import com.lquan.web.util.FormUtil;
@Controller
// @CrossOrigin(origins = "http://127.0.0.1:8080/testWj", maxAge = 3600)

@RequestMapping(value="question1")
public class QuestionController {
	
	@Resource(name="questionServer")
	public IQuestionServer questionServer;
	/**
	 * 添加问题和选项
	 * @param qu
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/search")
	public   void searchQuestionList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String user ="admin";
		long templateid = FormUtil.getLongFiledValue(request, "templateid");

		List<Question> qolist = this.questionServer.searchQuestionList(templateid);
		Map<String,Object> data = new HashedMap();
		data.put("objs", qolist);
		data.put("stateCode", "0");
		data.put("stateText", "");
		data.put("errors", "");
		data.put("count", qolist.size());
		
		
		JSONArray json = JSONArray.fromObject(data);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
		String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(resultStr.toString());			
		out.flush();			
		out.close();
	}
	
	/**
	 * 添加问题和选项
	 * @param qu
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/create")
	public   void toLogin(@RequestBody JSONObject qu,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String user ="admin";
		
		Question question = this.questionServer.ConverterQuestion(qu, user);
		Object[] arg = question.getObjectFile(); 
		arg[0] = question.getId();
		Boolean a = this.questionServer.createQuestion(arg);
		List<QueOption> qolist = this.questionServer.ConverterQueOption(qu, question.getId(), user);
		if(qolist!=null)
			question.setOptions(qolist);
		
		JSONArray json = JSONArray.fromObject(question);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
		String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(resultStr);			
		out.flush();			
		out.close();
	}
	
	/**
	 * 删除选项
	 * @param json
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public   void toDelete(@RequestBody JSONObject json,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String user ="admin";
		String message ="";
		
		if(this.questionServer.deleteQuestion(json))
			message = "message:success";
		else
			message = "message:error";
		//JSONArray json = JSONArray.fromObject(question);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
	//	String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(json.toString());			
		out.flush();			
		out.close();
	} 
	
	/**
	 * 问题排序
	 * @param json
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/move")
	@ResponseBody
	public   void toQuestMove(@RequestBody List<Orders> orderList,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String message ="";
		System.out.println("*********"+orderList.toString());
		/*String firstID = request.getParameter("firstID");
		String firstDispIndex = request.getParameter("firstDispIndex");
		String secondID = request.getParameter("secondID");
		String secondDispIndex = request.getParameter("secondDispIndex");*/
		
		for(Orders order :orderList){
			this.questionServer.moveQuestion(order.getId(), order.getDispIndex());
		}
	
		message = "[{message:success}]";
		JSONArray json = JSONArray.fromObject(orderList);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
		String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(resultStr);			
		out.flush();			
		out.close();
	} 	
	
	/**
	 * 保存题号及其他操作
	 * @param json
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public   void updateQuestionEx(@RequestBody JSONObject jsonObject,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String message ="";
		System.out.println("****xxxx*****"+jsonObject.toString());
		Question question = (Question) jsonObject.toBean(jsonObject, Question.class);
			this.questionServer.updateQuestion(question.getupdateArgs());
	
		message = "[{message:success}]";
		JSONArray json = JSONArray.fromObject(question);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
		//String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(json.toString());			
		out.flush();			
		out.close();
	} 

	/**
	 * 设置题目
	 * @param jsonObject
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/updatetitle")
	@ResponseBody
	public   void updateTitle(@RequestBody JSONObject jsonObject,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String message ="";
		System.out.println("****xxxx*****"+jsonObject.toString());
		Question question = (Question) jsonObject.toBean(jsonObject, Question.class);
			this.questionServer.updateQuestion(question.getupdateArgs());
	
		message = "[{message:success}]";
		JSONArray json = JSONArray.fromObject(question);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
		//String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(json.toString());			
		out.flush();			
		out.close();
	} 
}
