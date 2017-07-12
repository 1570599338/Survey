package com.lquan.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 拦截器，过滤掉不合法的路径
 * @author hurong
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	//	System.out.println("LoginInterceptor***"+request.getHeader("ticket"));
		/*response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("P3P", "CP=CAO PSA OUR");
        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
            response.addHeader("Access-Control-Allow-Methods", "POST,GET,TRACE,OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type,Origin,Accept");
            response.addHeader("Access-Control-Max-Age", "120");
        }*/
		/*String origin = request.getRemoteHost()+":"+request.getRemotePort(); 
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Max-Age", "3600"); 
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization"); 
		response.setHeader("Access-Control-Allow-Credentials","true"); 
	*/
		return true;
		
		/*System.out.println("*********"+request.getServletPath().toString());
		//return true;///System.out.println(request.getServletPath().toString());
		//接口的放行
		if (request.getServletPath().startsWith("/13")|| request.getServletPath().startsWith("/lastAnswer/basefinal")|| request.getServletPath().startsWith("/lastAnswer/flowfinal") || request.getServletPath().startsWith("/lastAnswer/satfinal")|| request.getServletPath().startsWith("/lastAnswer/allLastAnswer")){
			return true;
		}
		//用户登录--放行
		if (request.getServletPath().startsWith("/user/toLogin") || request.getServletPath().startsWith("/user/toCheck")) {
			// add lquan
			// 在登录和退出的时候对session中的所有的
			if(request.getSession().getAttribute(Constants.SESSION_PROJECT) != null)
				request.getSession().removeAttribute(Constants.SESSION_PROJECT);
			if (request.getSession().getAttribute(Constants.SESSION_USER) != null)
				request.getSession().removeAttribute(Constants.SESSION_USER);
			// --end
			
			return true;
		}
		// 静态资源访问--放行
		if(request.getServletPath().startsWith("/css/") || 
				request.getServletPath().startsWith("/img/") ||
				request.getServletPath().startsWith("/js/") ||
				request.getServletPath().startsWith("/jspage/") ||
				request.getServletPath().startsWith("/vm/") ||
				request.getServletPath().startsWith("/logs/")){
			return true;
		}
		// session不为空--放行
		if (request.getSession().getAttribute(Constants.SESSION_USER) != null) {
			return true;
		}
		// --add lquan
		if (request.getSession().getAttribute(Constants.SESSION_PROJECT) != null) {
			return true;
		}
		// --end
		//其他的操作则直接跳转到登录界面
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write("<script>parent.location.href='"+request.getContextPath()+"/user/toLogin'</script>");			
			out.flush();			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
		return false;*/
	}
}
