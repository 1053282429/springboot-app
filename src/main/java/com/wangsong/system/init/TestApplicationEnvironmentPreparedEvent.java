package com.wangsong.system.init;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

//@Configuration
public class TestApplicationEnvironmentPreparedEvent implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.out.println("ApplicationEnvironmentPreparedEvent======触发");
        System.out.println("333333333333333333333333333333333");

//        SpringApplication springApplication = new SpringApplication();
//        Set<String> sources = springApplication.getSources();

    }
}
