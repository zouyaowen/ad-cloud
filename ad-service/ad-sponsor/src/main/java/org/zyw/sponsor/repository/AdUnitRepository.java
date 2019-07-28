package org.zyw.sponsor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zyw.sponsor.entity.AdPlan;
import org.zyw.sponsor.entity.AdUnit;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 1:34 2019/7/27
 * @Modifyed by:
 */
public interface AdUnitRepository extends JpaRepository<AdUnit,Long> {
    /**
     * 根据推广计划唯一标识和推广单元名称获取推广单元
     * @param planId
     * @param unitName
     * @return
     */
    AdUnit findByPlanIdAndUnitName(Long planId,String unitName);

    /**
     * 根据推广单元状态获取所有的推广单元
     * @param unitStatus
     * @return
     */
    List<AdUnit> findAllByUnitStatus(Integer unitStatus);
}
