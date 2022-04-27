package com.wangsong.system.init;

import com.wangsong.system.entity.Resources;
import com.wangsong.system.service.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestPostConstruct {

    @Value("${access.user.name}")
    private String name;

    @Value("${access.port}")
    private String port;
    @Value("${spring.datasource.url}")
    private String url;

    @Autowired
    private IResourcesService iResourcesService;

    @Autowired
    private PropertySourcesTest propertySourcesTest;

    @Autowired
    private TestConfigParam configParam;
    @PostConstruct
    public void init(){
        String testValue = propertySourcesTest.getTestValue();
        System.out.println("PostConstruct print ==========================testValue"+testValue);
        System.out.println(name);
        System.out.println(port);
        System.out.println(url);
        Resources resources = iResourcesService.selectByPrimaryKey(1L);
        System.out.println(resources);
        System.out.println(configParam.toString());
        System.out.println(configParam.getUrl());
        System.out.println(configParam.getPort());
    }
}
