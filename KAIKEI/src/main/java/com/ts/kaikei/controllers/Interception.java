
package com.ts.kaikei.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interception extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(Interception.class);
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // String requestURI = request.getRequestURI();
    	// TODO: Authorization menu

        HttpSession session = request.getSession();
        
        if (session.getAttribute("id") != null) {
            return true;
        }
        
        request.setAttribute("errorMsg", "SESSION ERROR!");
        request.getRequestDispatcher("/error.do").forward(request, response);

        return false; 
	}
}