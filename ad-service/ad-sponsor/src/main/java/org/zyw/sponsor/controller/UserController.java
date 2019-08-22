package org.zyw.sponsor.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zyw.sponsor.vo.CreateUserRequest;
import org.zyw.sponsor.vo.CreateUserResponse;
import org.zyw.sponsor.service.IUserService;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 21:18 2019/7/28
 * @Modifyed by:
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        log.info("ad-sponsor: createUser -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

}
