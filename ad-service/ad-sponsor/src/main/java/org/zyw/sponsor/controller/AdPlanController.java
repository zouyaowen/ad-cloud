package org.zyw.sponsor.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zyw.sponsor.entity.AdPlan;
import org.zyw.sponsor.service.IAdPlanService;
import org.zyw.sponsor.vo.AdPlanGetRequest;
import org.zyw.sponsor.vo.AdPlanRequest;
import org.zyw.sponsor.vo.AdPlanResponse;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 21:21 2019/7/28
 * @Modifyed by:
 */
@Slf4j
@RestController
public class AdPlanController {
    @Autowired
    private IAdPlanService planService;

    @PostMapping("/create/adPlan")
    public AdPlanResponse createAdPlan(@RequestBody AdPlanRequest request) {
        log.info("ad-sponsor: createAdPlan -> {}", JSON.toJSONString(request));
        return planService.createAdPlan(request);
    }

    @PostMapping("/get/adPlan")
    public List<AdPlan> getAdPlanByIds(@RequestBody AdPlanGetRequest request) {
        log.info("ad-sponsor: getAdPlanByIds -> {}", JSON.toJSONString(request));
        return planService.getAdPlanByIds(request);
    }

    @PutMapping("/update/adPlan")
    public AdPlanResponse updateAdPlan(@RequestBody AdPlanRequest request) {
        log.info("ad-sponsor: updateAdPlan -> {}", JSON.toJSONString(request));
        return planService.updateAdPlan(request);
    }

    @DeleteMapping("/delete/adPlan")
    public void deleteAdPlan(@RequestBody AdPlanRequest request) {
        log.info("ad-sponsor: deleteAdPlan -> {}", JSON.toJSONString(request));
        planService.deleteAdPlan(request);
    }
}
