package com.wangsong.nacos.impl;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.wangsong.nacos.NacosService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class NacosServiceImpl implements NacosService {

    private static String serverAddr = "127.0.0.1:8848";

    private NacosListener listener = new NacosListener();

    NamingService naming;

    {
        try {
            naming = NamingFactory.createNamingService(serverAddr);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    private ConfigService getInstance() {
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = null;
        try {
            configService = NacosFactory.createConfigService(properties);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return configService;
    }

    @Override
    public String getConfig(String dataId, String group, long timeoutMs) throws NacosException {
        ConfigService configService = getInstance();
        return configService.getConfig(dataId, group, 5000);
    }

    @Override
    public void addListener(String dataId, String group) throws NacosException {
        ConfigService configService = getInstance();
        configService.addListener(dataId, group, listener);
        System.out.println("addListener=================="+listener);
    }

    @Override
    public void removeListener(String dataId, String group) throws NacosException {
        ConfigService configService = getInstance();
        configService.removeListener(dataId, group, listener);
        System.out.println("removeListener=================="+listener);
    }

    @Override
    public boolean publishConfig(String dataId, String group, String content) throws NacosException {
        ConfigService configService = getInstance();
        return configService.publishConfig(dataId,group,content);
    }

    @Override
    public boolean publishConfig(String dataId, String group, String content, String type) throws NacosException {
        ConfigService configService = getInstance();
        return configService.publishConfig(dataId,group,content,type);
    }

    @Override
    public boolean removeConfig(String dataId, String group) throws NacosException {
        ConfigService configService = getInstance();
        return configService.removeConfig(dataId, group);
    }

    @Override
    public void registerInstance(String serviceName, String ip, int port) throws NacosException {
        Instance instance = new Instance();
        instance.setIp(ip);
        instance.setPort(port);
        instance.setHealthy(true);
        instance.setWeight(1.0);
        Map<String, String> instanceMeta = new HashMap<>();
        instanceMeta.put("site", "et2");
        instance.setEphemeral(true);
        instance.setMetadata(instanceMeta);
        naming.registerInstance(serviceName, "test-group",instance);
    }

    @Override
    public void registerInstance(String serviceName, String ip, int port, String clusterName) throws NacosException {

    }

    @Override
    public void registerInstance(String serviceName, Instance instance) throws NacosException {

    }

    @Override
    public void deregisterInstance(String serviceName, String ip, int port) throws NacosException {
        naming.deregisterInstance(serviceName, "test-group", ip, port);
    }

    @Override
    public void deregisterInstance(String serviceName, String ip, int port, String clusterName) throws NacosException {

    }

    @Override
    public List<Instance> getAllInstances(String serviceName) throws NacosException {
        return null;
    }

    @Override
    public List<Instance> getAllInstances(String serviceName, List<String> clusters) throws NacosException {
        return null;
    }

    @Override
    public List<Instance> selectInstances(String serviceName, boolean healthy) throws NacosException {
        return null;
    }

    @Override
    public List<Instance> selectInstances(String serviceName, List<String> clusters, boolean healthy) throws NacosException {
        return null;
    }

    @Override
    public Instance selectOneHealthyInstance(String serviceName) throws NacosException {
        return null;
    }

    @Override
    public Instance selectOneHealthyInstance(String serviceName, List<String> clusters) throws NacosException {
        return null;
    }

    @Override
    public void subscribe(String serviceName, EventListener listener) throws NacosException {

    }

    @Override
    public void subscribe(String serviceName, List<String> clusters, EventListener listener) throws NacosException {

    }

    @Override
    public void unsubscribe(String serviceName, EventListener listener) throws NacosException {

    }

    @Override
    public void unsubscribe(String serviceName, List<String> clusters, EventListener listener) throws NacosException {

    }
}
