package com.wangsong.system.HBTest;

import com.wangsong.system.entity.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 10532
 */
@Component
public class SpringCustomListener implements ApplicationListener<SpringCustomEvent> {
    @Override
    public void onApplicationEvent(SpringCustomEvent event) {
        List list = event.list;
        User source = (User)event.getSource();
        System.out.println("自定义事件监听");
        System.out.println(source);
        System.out.println(list);
    }
}
