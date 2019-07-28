package org.zyw.sponsor.service;

import org.zyw.sponsor.entity.AdPlan;
import org.zyw.sponsor.vo.AdPlanGetRequest;
import org.zyw.sponsor.vo.AdPlanRequest;
import org.zyw.sponsor.vo.AdPlanResponse;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:21 2019/7/27
 * @Modifyed by:
 */
public interface IAdPlanService {

    /**
     * 添加推广计划
     * @param adPlanRequest
     * @return
     */
    AdPlanResponse createAdPlan(AdPlanRequest adPlanRequest);
    /**
     * 获取推广计划
     * @param adPlanGetRequest
     * @return
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest adPlanGetRequest);

    /**
     * 更新推广计划
     * @param adPlanRequest
     * @return
     */
    AdPlanResponse updateAdPlan(AdPlanRequest adPlanRequest);

    /**
     * 删除推广计划
     * @param adPlanRequest
     */
    void deleteAdPlan(AdPlanRequest adPlanRequest);
}
