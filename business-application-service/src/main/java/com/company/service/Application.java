package com.company.service;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jbpm.server.CamelKieServerExtension;
import org.apache.camel.impl.DefaultCamelContext;
import org.kie.server.services.api.KieServerExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean       
    KieServerExtension camelExtension(CamelContext camel) {        
        return new CamelKieServerExtension((DefaultCamelContext) camel);     
    }
}