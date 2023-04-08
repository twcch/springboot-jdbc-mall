package com.twcch.springbootjdbcmall.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        // 檢查 session 假設 user 為空，表示未登入
        if (request.getSession().getAttribute("user") == null) {
            // 重定向至登入頁面
            response.sendRedirect("/admin/login");
        }

        return true;

    }

}
