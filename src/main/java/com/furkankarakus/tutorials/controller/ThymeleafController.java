package com.furkankarakus.tutorials.controller;

import com.furkankarakus.tutorials.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {
    // Ctrl+alt+L = formmater
    //http://localhost:8080
    @GetMapping({"/index","/"})
    public String index(){
        return "index";
    }
    //http://localhost:8080/thymeleaf1
    //    @ResponseBody
    @GetMapping("/thymeleaf1")
    public String getThymeleaf1() {
        return "thymeleaf1";
    }
    // Model
    // http://localhost:8080/thymeleaf2

    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model_access_1", "I am coming from model-1");
        model.addAttribute("key_model_access_2", "I am coming from model-2");
        return "thymeleaf2";
    }
// Model birden fazla gondermek
    // http://localhost:8080/thymeleaf3

    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model_access_1", "I am coming from model-1");
        model.addAttribute("key_model_access_2", "I am coming from model-2");
        return "thymeleaf_file/thymeleaf3";
    }

    // http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model_access_1", "I am coming from model-1");
        model.addAttribute("key_model_access_2", "I am coming from model-2");
        return "thymeleaf4";
    }
    /* ********************************************** */
    //Model Object göndermek
    // http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5Model(Model model) {
        model.addAttribute("key_model_access_1", "text");
        return "thymeleaf5";
    }
    // Model Object List göndermek
    // http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelList(Model model) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(1L).productName("First Product").productPrice(1500).build());
        productDtoList.add(ProductDto.builder().productId(2L).productName("Second Product").productPrice(2500).build());
        productDtoList.add(ProductDto.builder().productId(3L).productName("Third Product").productPrice(3500).build());
        productDtoList.add(ProductDto.builder().productId(4L).productName("Fourth Product").productPrice(4500).build());
        model.addAttribute("key_model_access_1", "text");
        model.addAttribute("product_list", productDtoList);


        return "thymeleaf6";
    }

    // @PathVariable
    // http://localhost:8080/thymeleaf7/
    // http://localhost:8080/thymeleaf7/5
    @GetMapping({"/thymeleaf7/","/thymeleaf7/{id}"})
    public String getThymeleaf7ModelList(Model model, @PathVariable(name = "id", required = false) Long id) {
        if (id!=null){
            model.addAttribute("key_model_access_1", "id : " + id);
        }else {
            model.addAttribute("key_model_access_1", "id not founded!");
        }

        return "thymeleaf7";
    }

    // @RequestParam
    //http://localhost:8080/thymeleaf8?id=1&name=FurkanKarakus
    @GetMapping("/thymeleaf8")
    public String getThymeleaf8ModelList(Model model, @RequestParam(name = "id", required = false, defaultValue = "0") Long id, @RequestParam(name = "name") String name) {
        if (id!=null){
            model.addAttribute("key_model_access_1", "id : " + id + " -- name : " + name);
        }else {
            model.addAttribute("key_model_access_1", "id not founded!");
        }

        return "thymeleaf8";
    }
}
