package com.twcch.springbootjdbcmall.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())

                // 攔截的路徑
                .addPathPatterns("/admin/**")

                // 排除攔截的路徑
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");

    }
}
