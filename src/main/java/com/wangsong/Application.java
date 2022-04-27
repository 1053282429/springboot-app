package com.wangsong;

import com.wangsong.system.init.TestApplicationEnvironmentPreparedEvent;
import com.wangsong.system.init.TestApplicationPreparedEvent;
import com.wangsong.system.init.TestApplicationStartedEvent;
import com.wangsong.system.init.TestSpringApplicationEvent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.wangsong.*.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new TestApplicationEnvironmentPreparedEvent());
        springApplication.addListeners(new TestApplicationPreparedEvent());
        springApplication.addListeners(new TestApplicationStartedEvent());
        springApplication.addListeners(new TestSpringApplicationEvent());
        springApplication.run(args);
//        SpringApplication.run(Application.class, args);

    }


}