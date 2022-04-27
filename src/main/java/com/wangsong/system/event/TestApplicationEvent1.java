package com.wangsong.system.event;

import org.springframework.context.ApplicationEvent;

public class TestApplicationEvent1 extends ApplicationEvent {




    public TestApplicationEvent1(Object source) {
        super(source);
    }


    public void addProperties(){
//        ApplicationContext applicationContext = getApplicationContext();
//
//        ConfigurableEnvironment environment = (ConfigurableEnvironment) applicationContext.getEnvironment();
//
//
//
//        MutablePropertySources propertySources = environment.getPropertySources();
//
//        Resource classPathResource = new ClassPathResource("register1.properties");
//
//        try {
//            Properties properties = PropertiesLoaderUtils.loadProperties(classPathResource);
//            propertySources.addLast(new PropertiesPropertySource("event1.properties",properties));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        MutablePropertySources propertySources1 = environment.getPropertySources();


        System.out.println("自定义事件执行============TestApplicationEvent1");
    }

}
