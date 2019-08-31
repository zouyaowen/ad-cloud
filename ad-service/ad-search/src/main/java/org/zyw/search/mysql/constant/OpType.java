package org.zyw.search.mysql.constant;

import com.github.shyiko.mysql.binlog.event.EventType;

/**
 * @Author: zouyaowen
 * @Description: 索引操作类型
 * @Date: 21:25 2019/8/30
 * @Modifyed by:
 */
public enum OpType {
    /**
     * 添加、更新、删除、其他
     */
    ADD,
    UPDATE,
    DELETE,
    OTHER;

    public static OpType to(EventType eventType) {

        switch (eventType) {
            case EXT_WRITE_ROWS:
                return ADD;
            case EXT_UPDATE_ROWS:
                return UPDATE;
            case EXT_DELETE_ROWS:
                return DELETE;
            default:
                return OTHER;
        }
    }
}
