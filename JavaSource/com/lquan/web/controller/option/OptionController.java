package com.lquan.web.controller.option;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import snt.common.dao.base.PrimaryKeyGenerator;

import com.lquan.business.option.IOptionServer;
import com.lquan.business.option.IOptionServer2;
import com.lquan.business.question.IQuestionServer1;
import com.lquan.entity.Orders;
import com.lquan.entity.QueOption;
import com.lquan.entity.Question;

@Controller
@RequestMapping(value="/option1")
public class OptionController {
	
	@Resource(name="optionServer2")
	public IOptionServer2 optionServer;
	
	@RequestMapping(value="/move")
	@ResponseBody
	public   void toQuestMove(@RequestBody List<Orders> orderList,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String message ="";
		System.out.println("*********"+orderList.toString());
		
		for(Orders order :orderList){
			this.optionServer.moveOPtion(order.getId(), order.getDispIndex());
		}
	
		message = "message:success";
		//JSONArray json = JSONArray.fromObject(question);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
	//	String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(message.toString());			
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
	public void toLogin(@RequestBody List<QueOption> optionList,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String userName ="admin";
		 List<QueOption> options = new ArrayList<QueOption>();
		for(QueOption option :optionList){
			long id = PrimaryKeyGenerator.getLongKey();
			option.setId(id);
			option.setCreatedBy(userName);
			option.setUpdatedBy(userName);
			Object[] args = option.getObjectFile();
			args[0]=id;
			this.optionServer.createOPtion(args);
			options.add(option);
		}
		
		
		JSONArray json = JSONArray.fromObject(options);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
		String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(resultStr);			
		out.flush();			
		out.close();
	}
	
	
	@RequestMapping(value="/delete")
	public   void deleteOption(@RequestBody JSONObject  order,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		this.optionServer.deleteOption(order.getLong("id"));
		//JSONArray json = JSONArray.fromObject(question);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
	//	String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(order.toString());			
		out.flush();			
		out.close();
	} 
	
	@RequestMapping(value="/updatetitle")
	@ResponseBody
	public   void updateTitle(@RequestBody JSONObject jsonObject,HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/json; charset=UTF-8"); // 注意设置为json
		response.setCharacterEncoding("UTF-8");// 传送中文时防止乱码
		String message ="";
		System.out.println("****xxxx*****"+jsonObject.toString());
		QueOption option = (QueOption) jsonObject.toBean(jsonObject, QueOption.class);
			this.optionServer.updateOption(option.getupdateArgs());
	
		message = "[{message:success}]";
		JSONArray json = JSONArray.fromObject(option);
		PrintWriter out = response.getWriter();	
		//拼接的json数据多出一对“【】”，所以先去掉
		//String resultStr = json.toString().substring(1,json.toString().length()-1);
		out.write(json.toString());			
		out.flush();			
		out.close();
	} 

}
