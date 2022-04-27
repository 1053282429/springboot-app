package com.wangsong.system.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestEnvironmentPostProcessor implements EnvironmentPostProcessor{

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        System.out.println("EnvironmentPostProcessor ================= 触发");

        String name = "Config resource 'class path resource [application.properties]' via location 'optional:classpath:/'";
        MapPropertySource propertySource = (MapPropertySource)environment.getPropertySources().get(name);
        Map<String, Object> source = propertySource.getSource();
        HashMap<Object, Object> map = new HashMap<>();
        source.forEach((k,v)->{
            map.put(k,v.toString());
        });
        map.replace("access.user.name","bjc1111");
        map.replace("access.user.password","cloud");


        Resource classPathResource = new ClassPathResource("register.properties");


        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(classPathResource);
            map.putAll(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, Object> map1 = new HashMap<>();

        map.forEach((k,v)->{
         map1.put(k.toString(),v.toString());
        });

        map1.replace("register.url","11111111111");
        map1.replace("register.port","82222222");

        environment.getPropertySources().replace(name,new MapPropertySource(name,map1));

    }

}
