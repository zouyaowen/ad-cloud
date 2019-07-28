package org.zyw.search.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.zyw.annotation.IgnoreResponseAdvice;
import org.zyw.search.client.vo.AdPlan;
import org.zyw.search.client.vo.AdPlanGetRequest;
import org.zyw.search.feign.SponsorClient;
import org.zyw.vo.CommonResponse;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:03 2019/7/29
 * @Modifyed by:
 */
@RestController
@Slf4j
public class SearchController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SponsorClient sponsorClient;

    @PostMapping("/getAdPlans")
    @IgnoreResponseAdvice
    public CommonResponse getAdPlans(@RequestBody AdPlanGetRequest request){
        CommonResponse<List<AdPlan>> adPlans = sponsorClient.getAdPlans(request);
        return adPlans;
    }

    /**
     * 获取推广计划
     * @param request
     * @return
     */
    @PostMapping("/getAdPlansByRebbon")
    @IgnoreResponseAdvice
    public CommonResponse getAdPlansByRebbon(@RequestBody AdPlanGetRequest request){
        log.info("ad-search:getAdPlanByRebbon->{}", JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureka-client-ad-sponsor/get/adPlan",
                request,
                CommonResponse.class
        ).getBody();
    }
}
