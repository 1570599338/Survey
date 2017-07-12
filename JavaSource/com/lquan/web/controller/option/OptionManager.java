package com.lquan.web.controller.option;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lquan.business.option.IOptionServer;
import com.lquan.entity.Orders;
import com.lquan.entity.QueOption;
import com.lquan.web.util.JacksonJsonUtils;
import com.lquan.web.util.RespondSMSUtil;


@RestController
@RequestMapping(value="/option")
public class OptionManager {
	
	@Resource(name="optionServer")
	public IOptionServer optionServer;
	
	
	@RequestMapping(value = "/create")
    public @ResponseBody String createQuestion(@RequestParam String data) {
		System.out.println("*****add*****"+data);
		List<QueOption> objs = new ArrayList<QueOption>();
		List<Object> errors = new ArrayList<Object>();
		
		try {
			String user ="admin";
			// 转换题目
			//QueOption option = JacksonJsonUtils.DeserializationObjectIgnoreUnkown(data, QueOption.class);
			objs = JacksonJsonUtils.getStringCoverArrayList(data,QueOption.class);
			objs = this.optionServer.createOPtion(objs,user);
			data = RespondSMSUtil.generateResponseContentByObject(objs, "", objs.size());
		} catch (Exception e) {
			e.printStackTrace();
			errors.add(e);
			data =RespondSMSUtil.generateResponseContentByObject(objs, errors,objs.size());
		}
		
		 return data;
    }

	@RequestMapping(value = "/delete")
    public @ResponseBody String deleteOption(@RequestParam String data) {
		System.out.println("*****deleteOption*****"+data);
		List<QueOption> objs = new ArrayList<QueOption>();
		List<Object> errors = new ArrayList<Object>();
		
		try {
			String user ="admin";
			// 转换题目
			QueOption option = JacksonJsonUtils.DeserializationObjectIgnoreUnkown(data, QueOption.class);
			option = this.optionServer.deleteOption(option);
			objs.add(option);
			data = RespondSMSUtil.generateResponseContentByObject(objs, "", objs.size());
		} catch (Exception e) {
			e.printStackTrace();
			errors.add(e);
			data =RespondSMSUtil.generateResponseContentByObject(objs, errors,objs.size());
		}
		 return data;
    }

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/move")
    public @ResponseBody String moveOption(@RequestParam String data) {
		System.out.println("****move*****"+data);
		List<Orders> objs = new ArrayList<Orders>();
		List<Object> errors = new ArrayList<Object>();
		
		try {
			String user ="admin";
			// 转换题目
			objs = JacksonJsonUtils.getStringCoverArrayList(data,Orders.class);
			objs = this.optionServer.moveQueOPtion(objs);
			
			data = RespondSMSUtil.generateResponseContentByObject(objs, "", objs.size());
		} catch (Exception e) {
			e.printStackTrace();
			errors.add(e);
			data =RespondSMSUtil.generateResponseContentByObject(objs, errors,objs.size());
		}
		
			return data;
    }
	
	
	/**
	 * 修改题目选项的内容
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/updatetitle")
    public @ResponseBody String updateTitleOption(@RequestParam String data) {
		System.out.println("****updatetitle*****"+data);
		List<QueOption> objs = new ArrayList<QueOption>();
		List<Object> errors = new ArrayList<Object>();
		
		try {
			String user ="admin";
			// 转换题目
			QueOption option = JacksonJsonUtils.DeserializationObjectIgnoreUnkown(data,QueOption.class);
			option = this.optionServer.updateOption(option);
			objs.add(option);
			data = RespondSMSUtil.generateResponseContentByObject(objs, "", objs.size());
		} catch (Exception e) {
			e.printStackTrace();
			errors.add(e);
			data =RespondSMSUtil.generateResponseContentByObject(objs, errors,objs.size());
		}
		
			return data;
    }
	
}
