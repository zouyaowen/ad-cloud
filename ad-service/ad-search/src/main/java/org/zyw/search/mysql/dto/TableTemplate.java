package org.zyw.search.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zyw.search.mysql.constant.OpType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zouyaowen
 * @Description: 模板文件的中的表信息，此处为自己封装的
 * @Date: 14:19 2019/8/31
 * @Modifyed by:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableTemplate {
    private String tableName;
    /**
     * 索引所在层级
     * */
    private String level;
    /**
     * 一个表中的操作类型与多个列的映射
     */
    private Map<OpType, List<String>> opTypeFieldSetMap = new HashMap<>();

    /**
     * 字段索引 -> 字段名:binlog索引与列名的映射
     * */
    private Map<Integer, String> posMap = new HashMap<>();
}
