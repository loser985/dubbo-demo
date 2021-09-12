package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Reference(
            version = "2.0", //多版本
            timeout = 1000,//设置超时会覆盖生产端的超时设置
            loadbalance = "roundrobin", //负载均衡策略，按权重轮询
            cluster = "failover",      //容错策略，失败重试
            mock = "fail:return null") //降级策略，调用失败时返回空
    private UserService userService;

    @GetMapping("/sayHello")
    public String sayHello() {
        return userService.sayHello();
    }

    int i = 1;

    @GetMapping("/findUserById")
    public User findUserById() {
        /*new Thread(() -> {
            while (true) {
                System.out.println(i++);
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
        return userService.findUserById();
    }
}
