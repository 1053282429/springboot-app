package com.wangsong.system.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class TestApplicationEvent extends ApplicationEvent {

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }


    public TestApplicationEvent(Object source) {
        super(source);
    }


    public void addProperties(){
        ApplicationContext applicationContext = getApplicationContext();

        ConfigurableEnvironment environment = (ConfigurableEnvironment) applicationContext.getEnvironment();



        MutablePropertySources propertySources = environment.getPropertySources();

        Resource classPathResource = new ClassPathResource("register1.properties");

        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(classPathResource);
            propertySources.addLast(new PropertiesPropertySource("event.properties",properties));
        } catch (IOException e) {
            e.printStackTrace();
        }

        MutablePropertySources propertySources1 = environment.getPropertySources();


        System.out.println("自定义事件执行=============TestApplicationEvent");
    }

}
