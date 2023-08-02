package com.furkankarakus.tutorials.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;
@Controller
public class PostConstructTutorials {
//    @Autowired
//    Logger LOG;
//   // because "this.LOG" is null
////    public PostConstructTutorials(){
////        LOG.info("Invoke Log info.");
////    }
//
//    //bean henüz başlamadığından null  alıyoruz ve burada bağımlılığı enjecte edemiyoruz.
//    //Görevi: Bir bean nesnesi oluşturulduğunda hemen oluşur.
//
//    @PostConstruct
//    public void init(){
//        LOG.info("Invoke Log info");
//    }
//
//    public static void main(String[] args) {
//        PostConstructTutorials postConstructTutorials = new PostConstructTutorials();
//        System.out.println(postConstructTutorials);
//    }
}
