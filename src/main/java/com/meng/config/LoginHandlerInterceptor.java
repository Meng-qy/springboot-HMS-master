package com.meng.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //登录成功之后，应该有用户的session

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object loginUser = request.getSession().getAttribute("loginUser");

        if(loginUser ==null){
            request.setAttribute("msg","请先登录！");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }else{
            return true;
        }

    }
}
