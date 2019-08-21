package org.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.test.constant.Constant;

public class LoginInterceptor implements HandlerInterceptor {
	
	//不拦截的路径
	private static final String[] IGNORE_URI = {"/loginForm", "/login","/404.html"};
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView mv) throws Exception {
		
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		
		boolean flag = false; 
		
		String servletPath = request.getServletPath();
	 
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }
        
        if (!flag){
        	
        	Object user = request.getSession().getAttribute(Constant.USER_SESSION);
        	
        	if(user == null){
        		 
        		request.setAttribute("msg", "请登录!");
        		request.getRequestDispatcher(Constant.LOGIN).forward(request, response);
        		return flag;
        	}else{
        		 flag = true;
        	}
        }
        return flag;
		
	}

}