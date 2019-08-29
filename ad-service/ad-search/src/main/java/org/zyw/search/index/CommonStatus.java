package org.zyw.search.index;

import lombok.Getter;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:15 2019/8/28
 * @Modifyed by:
 */
@Getter
public enum CommonStatus {
    /**
     * 有效
     */
    VALID(1, "有效状态"),
    /**
     * 无效
     */
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
