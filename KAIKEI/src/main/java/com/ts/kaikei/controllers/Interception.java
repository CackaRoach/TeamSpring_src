
package com.ts.kaikei.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interception extends HandlerInterceptorAdapter {
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // String requestURI = request.getRequestURI();

        HttpSession session = request.getSession();
         
        if (session.getAttribute("id") != null) {
            return true;
        }
        
        request.setAttribute("errorMsg", "SESSION ERROR!");
        request.getRequestDispatcher("/error.do").forward(request, response);

        return false; 
	}
}