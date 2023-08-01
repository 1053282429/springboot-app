package com.wangsong.system.controller;


import com.wangsong.common.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-18
 */
@RestController
@RequestMapping("/system/user-role")
public class UserRoleController extends BaseController {

    private WebSocketServer webSocketServer = new WebSocketServer();

//    @Autowired
//    private WebSocketTest webSocketTest;
//
//    @PostConstruct
//    public void test(){
//        System.out.println(webSocketTest);
//    }

}
