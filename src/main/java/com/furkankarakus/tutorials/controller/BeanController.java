package com.furkankarakus.tutorials.controller;

import com.furkankarakus.tutorials.bean.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeanController {
    @Autowired
    BeanConfig beanConfig;

    // http://localhost:8080/bean/beanDto
    @GetMapping("/bean/beanDto") // url
    @ResponseBody // html olmadan direk ekranda gosterir
    public String getBeanDto(){
        return beanConfig.beanDto() + "";
    }
}
