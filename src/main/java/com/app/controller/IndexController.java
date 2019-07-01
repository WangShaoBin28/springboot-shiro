package com.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package com.app.controller
 * @ClassName IndexController
 * @Author shaobin.wang
 * @Date 2019/07/01 10:51
 * @Version 1.0
 * @Description:
 **/
@Controller
@Slf4j
public class IndexController {


    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

}
