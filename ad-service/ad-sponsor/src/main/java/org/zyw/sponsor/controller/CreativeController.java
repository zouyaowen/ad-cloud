package org.zyw.sponsor.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zyw.sponsor.vo.CreativeRequest;
import org.zyw.sponsor.vo.CreativeResponse;
import org.zyw.sponsor.service.ICreativeService;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 21:30 2019/7/28
 * @Modifyed by:
 */
@Slf4j
@RestController
public class CreativeController {

    @Autowired
    private ICreativeService creativeService;

    @PostMapping("/create/creative")
    public CreativeResponse createCreative(@RequestBody CreativeRequest request) {
        log.info("ad-sponsor: createCreative -> {}", JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}
