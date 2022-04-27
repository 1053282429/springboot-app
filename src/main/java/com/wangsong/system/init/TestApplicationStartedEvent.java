package com.wangsong.system.init;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;


//@Configuration
public class TestApplicationStartedEvent implements ApplicationListener<ApplicationStartedEvent> {

    private Integer i = 0;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("ApplicationStartedEvent======触发");
        System.out.println(i);
        i++;
        System.out.println("4444444444444444444444444444444444");
    }
}
