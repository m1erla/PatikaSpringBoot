package com.furkankarakus.bean;

import com.furkankarakus.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditorAwareBean {

    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }

}