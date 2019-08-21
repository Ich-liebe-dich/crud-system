package org.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.test.constant.Constant;

public class AdminPrivilegeInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		String user_type = (String)session.getAttribute(Constant.USER_TYPE);
		Object user = session.getAttribute(Constant.USER_SESSION);
		if(user==null) {
			return false;
		}
		if("student".equals(user_type)) {
		    return false;
		}else if("teacher".equals(user_type)) {
			return false;
		}else if("admin".equals(user_type)) {
			return true;
		}
		return false;
	}

}
