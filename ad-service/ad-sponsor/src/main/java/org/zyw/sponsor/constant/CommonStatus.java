package org.zyw.sponsor.constant;

import lombok.Getter;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 0:50 2019/7/26
 * @Modifyed by:
 */
@Getter
public enum CommonStatus {
    /**
     * 用户、推广计划有效状态
     */
    VALID(1, "有效状态"),
    /**
     * 用户、推广计划无效状态
     */
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
