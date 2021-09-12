package com.demo.service.impl;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service(
        timeout = 3000,//超时时间，默认超时1s
        retries = 2,//重试次数，重试默认2次
        version = "2.0",//版本
        weight = 100  //权重值
)
public class UserServiceImpl2 implements UserService {
    @Override
    public String sayHello() {
        return "hello world---1";
    }


    @Override
    public User findUserById() {
        System.out.println("new3 ....");
        User user = new User(3, "zhangsan", "123456");
       /* try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return user;
    }
}
