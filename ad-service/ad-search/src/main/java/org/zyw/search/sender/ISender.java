package org.zyw.search.sender;

import org.zyw.search.mysql.dto.MySqlRowData;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 17:26 2019/8/31
 * @Modifyed by:
 */
public interface ISender {

    /**
     * 发送消息
     * @param rowData
     */
    void sender(MySqlRowData rowData);
}
