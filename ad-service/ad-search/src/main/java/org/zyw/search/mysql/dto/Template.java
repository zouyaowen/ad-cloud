package org.zyw.search.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description: 模板文件的JSON映射
 * @Date: 14:15 2019/8/31
 * @Modifyed by:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Template {
    private String database;
    private List<JsonTable> tableList;
}
