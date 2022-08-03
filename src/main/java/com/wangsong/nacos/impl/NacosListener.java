package com.wangsong.nacos.impl;

import com.alibaba.nacos.api.config.listener.Listener;

import java.util.concurrent.Executor;

public class NacosListener implements Listener {

    @Override
    public Executor getExecutor() {
        System.out.println("触发getExecutor");
        return null;
//       return new Executor() {
//           @Override
//           public void execute(@NotNull Runnable command) {
//               new Thread(command).start();
//           }
//       };
    }

    @Override
    public void receiveConfigInfo(String configInfo) {
        System.out.println(configInfo);
    }
}
