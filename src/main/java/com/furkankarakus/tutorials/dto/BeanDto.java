package com.furkankarakus.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class BeanDto {
    private Long id;
    private String beanName;
    private String beanData;
    // start
    public void initialBeanMethod(){
        log.info("I am in before the bean starts!");
        System.out.println("The method to run before the bean starts!");
    }

    // finish

    public void destroyBeanMethod(){
        log.info("I am in after the bean is over!");
        System.err.println("The method to run after the bean is finished!");
    }
}
