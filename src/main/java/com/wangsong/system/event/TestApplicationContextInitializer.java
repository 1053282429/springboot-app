package com.wangsong.system.event;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;


//@Component
public class TestApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer==============================执行");


        applicationContext.publishEvent(new TestApplicationEvent(new Object()));

    }
}
