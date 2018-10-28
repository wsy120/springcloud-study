package com.springcloudstudy.userservice.service;

import com.springcloudstudy.common.bean.Address;
import com.springcloudstudy.common.bean.User;
import com.springcloudstudy.common.spring.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author yanghai
 * @date 2018/10/23 17:34
 */
@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    RestTemplate restTemplate;

    public User get(Map<String, Object> params) {
        logger.info("[start user service]");
        User user = new User();
        user.setId((String) params.get("id"));
        user.setName((String) params.get("name"));
        try {
            JsonResult<Address> jsonResult = restTemplate.postForEntity("http://new-service/addresscontroller/get", params, JsonResult.class).getBody();
            logger.info("[info-service的结果为]" + jsonResult.toString());
            user.setAddress(jsonResult.getData());
        } catch (Exception e) {
            throw JsonResult.ERR_ADDRESS_SERVICE;
        }
        logger.info("[end user service]");
        return user;
    }


    public User info(Map<String, Object> params) {
        return new User();
    }
}
