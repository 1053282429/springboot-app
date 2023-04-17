package com.wangsong.system.HBTest;

import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @author 10532
 */
public class SpringCustomEvent extends ApplicationEvent {


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public List list;

    public SpringCustomEvent(Object source, List list) {

        super(source);
        this.list = list;
    }
}
