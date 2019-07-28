package org.zyw.sponsor.service;

import org.zyw.sponsor.vo.*;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:01 2019/7/27
 * @Modifyed by:
 */
public interface IAdUnitService {
    /**
     * 添加推广单元
     * @param request
     * @return
     */
    AdUnitResponse createUnit(AdUnitRequest request);

    /**
     * 添加关键词维度
     * @param request
     * @return
     */
    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request);

    /**
     * 添加兴趣维度限制
     * @param request
     * @return
     */
    AdUnitItResponse createUnitIt(AdUnitItRequest request);

    /**
     * 添加地域维度限制
     * @param request
     * @return
     */
    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request);

    /**
     * 添加创意与创意推广单元的关联表创建
     * @param request
     * @return
     */
    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request);
}
