package top.heapoverflow.yunnote.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.heapoverflow.yunnote.interceptor.LoginInterceptor;

/**
 * @author lhg
 * @date 2019-03-12 14:38
 * @description 登录拦截和跨域设置
 */
@Configuration
public class LoginAndCorsConfig implements WebMvcConfigurer {
    /**
     * 登录拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/logout");
    }

    /**
     * 跨域设置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }
}