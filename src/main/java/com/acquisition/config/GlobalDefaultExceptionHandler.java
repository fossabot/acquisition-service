package com.acquisition.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 全局异常处理
 * @author yxk
 * @create 2019/5/30
 * @since 1.0.0
 */
/*@ControllerAdvice*/
public class GlobalDefaultExceptionHandler {

    /**
     * 可以返回自定义的错误页面
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    private ModelAndView returnErrorPage(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", "404");
        mv.setViewName("/errors");//错误页面地址
        return mv;
    }

}
