package org.zyw.search.feign;

import org.springframework.stereotype.Component;
import org.zyw.search.client.vo.AdPlan;
import org.zyw.search.client.vo.AdPlanGetRequest;
import org.zyw.common.vo.CommonResponse;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:17 2019/7/29
 * @Modifyed by:
 */
@Component
public class SponsorClientHystrix implements SponsorClient {
    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1, "eureka-client-ad-sponsor error");
    }
}
