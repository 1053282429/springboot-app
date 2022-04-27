package com.wangsong.system.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:/register.properties"})
public class PropertySourcesTest {

//    register.ip=10.35.226.88
//    register.port=8888
//    register.username=${access.user.name}
//    register.password=${access.user.password}
//    register.url
    @Value("${register.ip}")
    private String ip;
    @Value("${register.port}")
    private String port;
    @Value("${register.username}")
    private String username;
    @Value("${register.password}")
    private String password;
    @Value("${register.url}")
    private String url;
    @Value("${testvalue}")
    private String testValue;

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
