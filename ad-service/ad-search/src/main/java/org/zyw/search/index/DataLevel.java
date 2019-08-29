package org.zyw.search.index;

import lombok.Getter;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:15 2019/8/28
 * @Modifyed by:
 */
@Getter
public enum DataLevel {
    /**
     * 第二层级
     */
    LEVEL2("2", "level 2"),
    /**
     * 第三层级
     */
    LEVEL3("3", "level 3"),
    /**
     * 第四层级
     */
    LEVEL4("4", "level 4");

    private String level;
    private String desc;

    DataLevel(String level, String desc) {
        this.level = level;
        this.desc = desc;
    }
}
