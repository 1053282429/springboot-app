package com.wangsong.system.event;

import org.springframework.context.ApplicationListener;


public class TestApplicationListener1 implements ApplicationListener<TestApplicationEvent1> {
    @Override
    public void onApplicationEvent(TestApplicationEvent1 event) {

        event.addProperties();

    }
}
