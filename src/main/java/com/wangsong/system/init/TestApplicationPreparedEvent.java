package com.wangsong.system.init;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

//@Configuration
public class TestApplicationPreparedEvent implements ApplicationListener<ApplicationPreparedEvent> {

    public ConfigurableEnvironment environment1;
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        ConfigurableApplicationContext applicationContext = applicationPreparedEvent.getApplicationContext();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        this.environment1 = environment;
        MutablePropertySources propertySources = environment.getPropertySources();
        System.out.println("ApplicationPreparedEvent======触发");
        System.out.println("222222222222222222222222222222222");

        Resource classPathResource = new ClassPathResource("register.properties");

        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(classPathResource);
            propertySources.addLast(new PropertiesPropertySource("ApplicationPreparedEvent.properties",properties));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
