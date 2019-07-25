package org.zyw.sponsor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zyw.sponsor.entity.AdPlan;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 1:58 2019/7/26
 * @Modifyed by:
 */
public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {
    /**
     * 根据主键和用户唯一标识获取推广计划
     * @param id
     * @param userId
     * @return
     */
    AdPlan findByIdAndAndUserId(Long id,Long userId);

    /**
     * 根据批量主键和用户唯一标识获取推广计划
     * @param ids
     * @param userId
     * @return
     */
    List<AdPlan> findAllByIdInAndAndUserId(List<Long> ids, Long userId);

    /**
     * 根据推广计划唯一标识和推广名称获取推广计划
     * @param id
     * @param planName
     * @return
     */
    AdPlan findByIdAndAndAndPlanName(Long id,String planName);

    /**
     * 根据推广计划状态获取推广计划
     * @param status
     * @return
     */
    List<AdPlan> findAllByAndPlanStatus(Integer status);
}
