package com.wangsong.system.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof TestCommandLineRunner) {
            TestCommandLineRunner bean1 = (TestCommandLineRunner) bean;
        }
        return null;
    }
}
