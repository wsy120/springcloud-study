package com.springcloudstudy.userservice.controller;

import com.springcloudstudy.common.bean.Result;
import com.springcloudstudy.common.bean.User;
import com.springcloudstudy.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/23 17:34
 */
@RestController
@RequestMapping("/usercontroller")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    public User get(@RequestBody Map<String, Object> params) {
        logger.info("/usercontroller/get");
        User user = userService.get(params);
        return user;
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Map<String, Object> params) {
        User info = userService.info(params);
        return new Result("1", "success", info);
    }

}
