package org.zyw.search.mysql.listener;

import org.zyw.search.mysql.dto.BinlogRowData;

/**
 * @Author: zouyaowen
 * @Description: 监听接口
 * @Date: 15:56 2019/8/31
 * @Modifyed by:
 */
public interface IListener {
    /**
     * 注册
     */
    void register();

    /**
     * 实现接口方法
     * @param eventData
     */
    void onEvent(BinlogRowData eventData);
}
