package com.ts.kaikei.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ts.kaikei.vo.UserVO;

public class Interception extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // String requestURI = request.getRequestURI();

        HttpSession session = request.getSession();
        UserVO userVO = (UserVO)session.getAttribute("userVO");
        
        if (userVO != null) {
            return true;
        }

        request.getRequestDispatcher("/error.do").forward(request, response);

        return false;
	}
}
