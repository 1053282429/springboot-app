package com.wangsong.system.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;


@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor, ApplicationEventPublisherAware {


    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        applicationEventPublisher.publishEvent(new TestApplicationEvent1(new Object()));


//        MutablePropertySources propertySources = environment.getPropertySources();
//        SpringApplicationEvent springApplicationEvent = new Spring`;
//        ApplicationContext applicationContext1 = new ApplicationContext();
//        applicationContext1.getContext()
//        ConfigurableApplicationContext applicationContext =/
        System.out.println("BeanFactoryPostProcessor===============执行");
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
