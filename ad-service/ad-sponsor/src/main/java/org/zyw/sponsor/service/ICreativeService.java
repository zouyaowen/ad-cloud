package org.zyw.sponsor.service;

import org.zyw.sponsor.vo.CreativeRequest;
import org.zyw.sponsor.vo.CreativeResponse;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 20:59 2019/7/28
 * @Modifyed by:
 */
public interface ICreativeService {
    /**
     * 添加创意
     * @param request
     * @return
     */
    CreativeResponse createCreative(CreativeRequest request);
}
