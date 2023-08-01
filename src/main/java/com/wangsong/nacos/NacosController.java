package com.wangsong.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.wangsong.system.HBTest.TestPublishEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nacos")
public class NacosController {

    @Autowired
    private NacosService nacosService;

    @Autowired
    private TestPublishEvent testPublishEvent;
//    @Autowired
//    private EmailTool emailTool;






    @PostMapping("/publishConfig")
    private void publishConfig(){

        MailUtils.sendMails();
//        try {

//            String[] filePath = new String[]{"E:\\01.png"};
//
//            Map<String, Object> valueMap = new HashMap<>();
//            valueMap.put("to", new String[]{"1053282429@qq.com", "2924476348@qq.com"});
//            valueMap.put("title", "test邮件标题");
//            valueMap.put("content", "test邮件内容");
//            valueMap.put("filePathList", filePath);
//
//            emailTool.sendSimpleMail(valueMap);


//            testPublishEvent.testPublishEvent();
//            JSONObject jsonObject = new JSONObject();
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("ip","127.0.0.1");
//            jsonObject.putAll(map);
//            boolean b = nacosService.publishConfig("server", "test", jsonObject.toString(), "json");
//            System.out.println("publishConfig======="+b);
//        } catch (NacosException e) {
//            e.printStackTrace();
//        }
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

    @PostMapping("/removeConfig")
    private void removeConfig(){
        try {
            boolean b = nacosService.removeConfig("server", "test");
            System.out.println("removeConfig======="+b);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }


    @PostMapping("/register")
    private void register(){
        try {
            nacosService.registerInstance("testService","127.0.0.1",8080);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/deleteRegister")
    private void deleteRegister(){
        try {
            nacosService.deregisterInstance("testService","127.0.0.1",8080);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/getServiceList")
    private void getServiceList(){
        try {
            List<Instance> testService = nacosService.selectInstances("testService", true);
            System.out.println("获取的服务列表");
            System.out.println(testService);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

}
