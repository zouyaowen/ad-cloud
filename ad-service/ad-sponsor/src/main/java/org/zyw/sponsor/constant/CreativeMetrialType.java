package org.zyw.sponsor.constant;

/**
 * @Author: zouyaowen
 * @Description: 创意物料类型
 * @Date: 1:46 2019/7/26
 * @Modifyed by:
 */
public enum CreativeMetrialType {
    /**
     * jpg图片
     */
    JPG(1, "jpg"),
    /**
     * bmp图片
     */
    BMP(2, "bmp"),

    /**
     * mp4视频
     */
    MP4(3, "mp4"),
    /**
     * avi视频
     */
    AVI(4, "avi"),

    /**
     * txt文本
     */
    TXT(5, "txt");

    private int type;
    private String desc;

    CreativeMetrialType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
