package org.zyw.search.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zyw.search.mysql.constant.OpType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zouyaowen
 * @Description: 最后需要投递的数据
 * @Date: 17:12 2019/8/31
 * @Modifyed by:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MySqlRowData {
    /**
     * 单个数据库只定义表名
     */
    private String tableName;
    /**
     * 索引层级
     */
    private String level;
    /**
     * EventType到opType的转换
     */
    private OpType opType;
    private List<Map<String, String>> fieldValueMap = new ArrayList<>();
}
