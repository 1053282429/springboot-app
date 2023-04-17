package com.wangsong.system.HBTest;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author 10532
 */
@Component
public class TestInnerClass {

    @EventListener()
    public void test(SpringCustomEvent event) {
        System.out.println("内部类事件监听");
    }
}
