package com.wangsong.system.HBTest;

import com.wangsong.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TestPublishEvent {

    @Autowired
    private ApplicationContext applicationContext;

    public  void testPublishEvent(){
        List<int[]> list = Arrays.asList(new int[]{1, 2, 3});
        User user = new User();
        user.setUsername("111");
        user.setId(1L);
        applicationContext.publishEvent(new SpringCustomEvent(user,list));

    }

}
