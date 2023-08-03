package com.furkankarakus.tutorials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {
    //http://localhost:8080/thymeleaf1


//    @ResponseBody
    @GetMapping("/thymeleaf1")
    public String getThymeleaf1(){
        return "thymeleaf1";
    }
    // Model birden fazla gondermek
    // http://localhost:8080/thymeleaf2

    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model){
       model.addAttribute("key_model_access_1","I am coming from model-1");
       model.addAttribute("key_model_access_2","I am coming from model-2");
        return "thymeleaf2";
    }

    // http://localhost:8080/thymeleaf3

    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model){
        model.addAttribute("key_model_access_1","I am coming from model-1");
        model.addAttribute("key_model_access_2","I am coming from model-2");
        return "thymeleaf_file/thymeleaf3";
    }
    // http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model){
        model.addAttribute("key_model_access_1","I am coming from model-1");
        model.addAttribute("key_model_access_2","I am coming from model-2");
        return "thymeleaf4";
    }
}
