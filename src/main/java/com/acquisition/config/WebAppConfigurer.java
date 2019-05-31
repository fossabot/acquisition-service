package com.acquisition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author yxk
 * @Description: WEB MVC视图解析器
 * @create 2019/5/30
 * @since 1.0.0
 */
public class WebAppConfigurer  implements WebMvcConfigurer {


    /**
     * springmvc视图解析  (现在使用thymeleaf)
     * @Title: viewResolver
     * @Description: TODO
     * @Date 2018年8月28日 下午4:46:07
     * @author OnlyMate
     * @return
     */
  /*  @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("classpath:/static");
        viewResolver.setSuffix(".html");
        // viewResolver.setViewClass(JstlView.class); // 这个属性通常并不需要手动配置，高版本的Spring会自动检测
        return viewResolver;
    }*/


    /**
     * 默认页面
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
