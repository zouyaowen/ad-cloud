package org.zyw.search.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description: 模板文件中的表信息
 * @Date: 14:09 2019/8/31
 * @Modifyed by:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonTable {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 表所属层级
     */
    private Integer level;
    /**
     * 添加数据
     */
    private List<Column> insert;
    /**
     * 更新数据
     */
    private List<Column> update;
    /**
     * 删除数据
     */
    private List<Column> delete;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Column {
        private String column;
    }
}
