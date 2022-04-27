package com.wangsong.system.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class TestApplicationListener implements ApplicationListener<TestApplicationEvent> {
    @Override
    public void onApplicationEvent(TestApplicationEvent event) {

        event.addProperties();

    }
}
