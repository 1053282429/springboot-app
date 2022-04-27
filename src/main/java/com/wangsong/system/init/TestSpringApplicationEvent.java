package com.wangsong.system.init;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;


//@Configuration
public class TestSpringApplicationEvent implements ApplicationListener<SpringApplicationEvent> {

    private Integer i = 0;

    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        System.out.println("SpringApplicationEvent ================= 项目加载");
        System.out.println(i);
        i++;
        if (event instanceof ApplicationStartingEvent) {
            event.getSource();
            System.out.println("ApplicationStartingEvent ================= 项目加载");
            System.out.println(i);
            i++;
        } else if (event instanceof ApplicationReadyEvent) {
            System.out.println("ApplicationReadyEvent ================= 项目启动完成");
            System.out.println(i);
        }
    }
}
