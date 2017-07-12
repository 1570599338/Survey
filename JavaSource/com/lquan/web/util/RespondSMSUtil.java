package com.lquan.web.util;

import java.util.LinkedHashMap;

public class RespondSMSUtil {
	 /**
     * 生成响应内容。
     *
     * @param data    返回数据。
     * @param message 状态说明。
     * @param status  状态。
     * @return 响应内容。
     */
    public static String generateResponseContent(String data,String message,int status) {
        LinkedHashMap<String, String> content = new LinkedHashMap<String, String>();
        content.put("data", data);
        content.put("message", message);
        content.put("status", String.valueOf(status));
        return JsonUtils.genericObjectToJsonStr(content);
    }

    
    public static String generateResponseContentByObject(Object data, Object errors,Integer status) {
        return generateResponseContentByObject( data,  errors,"", "","",status);
    }
    /**
     * 以对象为传入值生成相应内容
     * @param data
     * @param msg
     * @param status
     * @return
     */
    public static String generateResponseContentByObject(Object data, Object errors, String stateCode,String stateText,String runtime, Integer status) {
        LinkedHashMap<String, Object> content = new LinkedHashMap<String, Object>();
        content.put("objs", data);
        content.put("errors", errors);
        content.put("stateCode", stateCode);
        content.put("stateText", stateText);
        content.put("runtime", String.valueOf(runtime));
        content.put("count", String.valueOf(status==null? 0:status));
        return JsonUtils.genericObjectToJsonStr(content);
    }

    public static String generateSignRespStr(Object data, String msg, Integer status, Object sign) {
        LinkedHashMap<String, Object> content = new LinkedHashMap<String, Object>();
        content.put("data", data);
        content.put("stateCode", sign);
        content.put("stateText", msg);
        content.put("runtime", String.valueOf(status));
        content.put("count", String.valueOf(status));
        return JsonUtils.genericObjectToJsonStr(content);
    }

}
