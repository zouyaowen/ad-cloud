package org.zyw.search.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zyw.search.mysql.constant.OpType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Author: zouyaowen
 * @Description: 模板解析对象
 * @Date: 14:22 2019/8/31
 * @Modifyed by:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParseTemplate {
    /**
     * 数据库名
     */
    private String database;
    /**
     * 数据库表名到表数据信息的映射
     */
    private Map<String, TableTemplate> tableTemplateMap = new HashMap<>();

    /**
     * 解析数据库信息
     * @param _template
     * @return
     */
    public static ParseTemplate parse(Template _template) {
        ParseTemplate template = new ParseTemplate();
        template.setDatabase(_template.getDatabase());
        for (JsonTable table : _template.getTableList()) {
            String name = table.getTableName();
            Integer level = table.getLevel();
            TableTemplate tableTemplate = new TableTemplate();
            //设置表名与表层级
            tableTemplate.setTableName(name);
            tableTemplate.setLevel(level.toString());
            template.tableTemplateMap.put(name, tableTemplate);

            // 遍历操作类型对应的列
            Map<OpType, List<String>> opTypeFieldSetMap =
                    tableTemplate.getOpTypeFieldSetMap();

            //此处完成操作类型与列名之间的映射
            for (JsonTable.Column column : table.getInsert()) {
                getAndCreateIfNeed(
                        OpType.ADD,
                        opTypeFieldSetMap,
                        ArrayList::new
                ).add(column.getColumn());
            }
            for (JsonTable.Column column : table.getUpdate()) {
                getAndCreateIfNeed(
                        OpType.UPDATE,
                        opTypeFieldSetMap,
                        ArrayList::new
                ).add(column.getColumn());
            }
            for (JsonTable.Column column : table.getDelete()) {
                getAndCreateIfNeed(
                        OpType.DELETE,
                        opTypeFieldSetMap,
                        ArrayList::new
                ).add(column.getColumn());
            }
        }
        return template;
    }

    private static <T, R> R getAndCreateIfNeed(T key, Map<T, R> map,
                                               Supplier<R> factory) {
        return map.computeIfAbsent(key, k -> factory.get());
    }
}
