package com.acquisition.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@RestController
@RequestMapping(value = "/generateScript")
public class GenerateScriptController {

    private final static Logger LOGGER = LoggerFactory.getLogger(GenerateScriptController.class);

}
