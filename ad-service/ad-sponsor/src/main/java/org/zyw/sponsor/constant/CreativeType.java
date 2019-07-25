package org.zyw.sponsor.constant;

/**
 * @Author: zouyaowen
 * @Description: 创意类型
 * @Date: 1:43 2019/7/26
 * @Modifyed by:
 */
public enum CreativeType {
    /**
     * 图片
     */
    IMAGE(1, "图片"),
    /**
     * 视频
     */
    VIDEO(2, "视频"),
    /**
     * 文本
     */
    TEXT(3, "文本");

    private int type;
    private String desc;

    CreativeType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
