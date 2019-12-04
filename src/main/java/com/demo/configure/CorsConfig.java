package com.demo.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置拦截器
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOrigins("*")
                // 设置接收cookie
                .allowCredentials(true)
                // 设置允许的方法
                .allowedMethods("*")
                // 设置允许头
                .allowedHeaders("*")
//                .exposedHeaders(/*"access-control-allow-headers",
//                        "access-control-allow-methods",
//                        "access-control-allow-origin",
//                        "access-control-max-age",
//                        "X-Frame-Options",*/
//                        ConstBean.ACCSS_TOKEN,
//                        ConstBean.FILENAME)
                // 跨域允许时间
                .maxAge(3600);
    }
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckRolePermissionInterceptor()).addPathPatterns("/**");
    }*/


    /**
     * 跨域配置后swagger2可能不能访问，需要增加如下配置
     * @param registry
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/index.html")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
//    @Bean
//    CheckLoginInterceptor localInterceptor() {
//        return new CheckLoginInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/user/login")
//                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
//    }
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }

}
