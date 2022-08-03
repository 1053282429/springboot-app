package com.wangsong.nacos;

import cn.hutool.json.JSONObject;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/nacos")
public class NacosController {

    @Autowired
    private NacosService nacosService;


    @PostMapping("/publishConfig")
    private void publishConfig(){
        try {
            JSONObject jsonObject = new JSONObject();
            HashMap<String, Object> map = new HashMap<>();
            map.put("ip","127.0.0.1");
            jsonObject.putAll(map);
            boolean b = nacosService.publishConfig("server", "test", jsonObject.toString(), "json");
            System.out.println("publishConfig======="+b);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/getConfig")
    private void getConfig(){
        try {
            String config = nacosService.getConfig("server", "test", 10000L);
            System.out.println(config);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/addListener")
    private void addListener(){
        try {
            nacosService.addListener("server", "test");
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/removeListener")
    private void removeListener(){
        try {
            nacosService.removeListener("server","test");
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/removeConfig")
    private void removeConfig(){
        try {
            boolean b = nacosService.removeConfig("server", "test");
            System.out.println("removeConfig======="+b);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }



}
