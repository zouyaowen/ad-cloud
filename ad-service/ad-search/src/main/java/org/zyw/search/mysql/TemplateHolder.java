package org.zyw.search.mysql;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.zyw.search.mysql.constant.OpType;
import org.zyw.search.mysql.dto.ParseTemplate;
import org.zyw.search.mysql.dto.TableTemplate;
import org.zyw.search.mysql.dto.Template;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @Author: zouyaowen
 * @Description: 加载模板文件的入口
 * @Date: 15:35 2019/8/31
 * @Modifyed by:
 */
@Slf4j
@Component
public class TemplateHolder {
    /**
     *此处需要获取相关对象
     */
    private ParseTemplate template;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 两个参数，一个是数据库名，另一个是表名
     */
    private String SQL_SCHEMA = "select table_schema, table_name, " +
            "column_name, ordinal_position from information_schema.columns " +
            "where table_schema = ? and table_name = ?";

    @PostConstruct
    private void init() {
        loadJson("template.json");
    }

    public TableTemplate getTable(String tableName) {
        return template.getTableTemplateMap().get(tableName);
    }

    private void loadJson(String path) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream inStream = cl.getResourceAsStream(path);
        try {
            Template template = JSON.parseObject(
                    inStream,
                    Charset.defaultCharset(),
                    Template.class
            );
            this.template = ParseTemplate.parse(template);
            loadMeta();
        } catch (IOException ex) {
            log.error(ex.getMessage());
            throw new RuntimeException("fail to parse json file");
        }
    }

    /**
     * 此处完成列索引与列名的映射关系
     */
    private void loadMeta() {
        for (Map.Entry<String, TableTemplate> entry :
                template.getTableTemplateMap().entrySet()) {
            TableTemplate table = entry.getValue();
            //
            List<String> updateFields = table.getOpTypeFieldSetMap().get(
                    OpType.UPDATE
            );
            List<String> insertFields = table.getOpTypeFieldSetMap().get(
                    OpType.ADD
            );
            List<String> deleteFields = table.getOpTypeFieldSetMap().get(
                    OpType.DELETE
            );
            //构建列索引与列之间的映射关系
            jdbcTemplate.query(SQL_SCHEMA, new Object[]{
                    template.getDatabase(), table.getTableName()
            }, (rs, i) -> {
                int pos = rs.getInt("ORDINAL_POSITION");
                String colName = rs.getString("COLUMN_NAME");
                if ((null != updateFields && updateFields.contains(colName))
                        || (null != insertFields && insertFields.contains(colName))
                        || (null != deleteFields && deleteFields.contains(colName))) {
                    table.getPosMap().put(pos - 1, colName);
                }
                return null;
            });
        }
    }

}
