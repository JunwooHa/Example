package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.model.vo.AccountVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		String cpath = request.getContextPath();
		
		HttpSession session = request.getSession();
		AccountVO user = (AccountVO) session.getAttribute("user");
		
		if (user == null) {
			response.sendRedirect(cpath + "/acc/login");
			return false;
		}
		
		return true;
	}
}
