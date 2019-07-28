package org.zyw.search.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zyw.search.client.vo.AdPlan;
import org.zyw.search.client.vo.AdPlanGetRequest;
import org.zyw.vo.CommonResponse;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:15 2019/7/29
 * @Modifyed by:
 */
@FeignClient(value = "eureka-client-ad-sponsor", fallback = SponsorClientHystrix.class)
public interface SponsorClient {
    /**
     * 通过Feign调用接口
     * @param request 请求参数
     * @return CommonResponse<List<AdPlan>>
     */
    @RequestMapping(value = "/ad-sponsor/get/adPlan", method = RequestMethod.POST)
    CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request);
}
