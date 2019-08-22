package org.zyw.sponsor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 23:20 2019/8/21
 * @Modifyed by:
 */
@RestController
@Slf4j
public class TestComtroller {
    @GetMapping("/getData")
    public void getData() {
        log.info("------getData------");
    }

    @PostMapping("/postData")
    public void postData() {
        log.info("------postData------");
    }

}
