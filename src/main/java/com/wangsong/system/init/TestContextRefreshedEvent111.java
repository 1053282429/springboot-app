package com.wangsong.system.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class TestContextRefreshedEvent111 implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${access.user.name}")
    private String name;
    @Value("${access.port}")
    private String port;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        Environment environment = applicationContext.getEnvironment();
        System.out.println("ContextRefreshedEvent print ==========================");
        System.out.println(name);
        System.out.println(port);
    }
}
