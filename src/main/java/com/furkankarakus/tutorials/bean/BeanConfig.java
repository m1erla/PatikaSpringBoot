package com.furkankarakus.tutorials.bean;

import com.furkankarakus.tutorials.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBeanMethod",destroyMethod = "destroyBeanMethod")
    @Scope("singleton")// request session
    public BeanDto beanDto(){
        return BeanDto
                .builder()
                    .id(1L).beanName("bean Name").beanData("bean Data")
                .build();
    }
}
