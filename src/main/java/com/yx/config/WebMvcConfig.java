package com.yx.config;

import com.yx.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YinXiong
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final static  String[] PATH_PATTERN_IGNORE={"/login/login", "/**/*.js", "/**/*.css", "/**/*.html", "/**/*.gif", "/**/*.ico"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**")
                .excludePathPatterns(PATH_PATTERN_IGNORE);
    }

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
}