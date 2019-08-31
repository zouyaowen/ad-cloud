package org.zyw.search.mysql.dto;

import com.github.shyiko.mysql.binlog.event.EventType;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author: zouyaowen
 * @Description: 自定义监听接口参数对象及事件中的数据渲染对象
 * @Date: 15:51 2019/8/31
 * @Modifyed by:
 */
@Data
public class BinlogRowData {
    private TableTemplate table;
    private EventType eventType;
    /**
     * map为列名与列对应的值得一映射
     */
    private List<Map<String, String>> after;

    private List<Map<String, String>> before;
}
