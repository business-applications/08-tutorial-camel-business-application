package com.company.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyCamelRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jbpm:events:process")
        .transacted()
        .filter(header("EventType").startsWith("before"))
        .transform(simple("${in.header.EventType} for ${body.processInstance.id}"))
        .to("kafka:TestLog");
    }

}
