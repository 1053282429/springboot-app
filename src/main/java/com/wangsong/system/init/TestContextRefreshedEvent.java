package com.wangsong.system.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
public class TestContextRefreshedEvent implements ApplicationListener<ContextRefreshedEvent> , Ordered {

    @Autowired
    private ConfigurableEnvironment environment;


    @Autowired
    private ApplicationContext context;

    @Autowired
    private PropertySourcesTest propertySourcesTest;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        String testValue = propertySourcesTest.getTestValue();
        System.out.println(testValue);

    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
