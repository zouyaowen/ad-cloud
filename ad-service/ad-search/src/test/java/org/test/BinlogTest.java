package org.test;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

import java.io.IOException;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 23:25 2019/8/30
 * @Modifyed by:
 */
public class BinlogTest {
    public static void main(String[] args) throws IOException {
        BinaryLogClient client = new BinaryLogClient(
                "127.0.0.1",
                3306,
                "root",
                "123456"
        );
        /**
         * 测试数据增改删
         * Write---------------
         * WriteRowsEventData{tableId=108, includedColumns={0, 1, 2, 3, 4, 5}, rows=[
         *     [14, AAA, sdfsdfgsd, 1, Thu Jan 01 08:00:00 CST 1970, Thu Jan 01 08:00:00 CST 1970]
         * ]}
         * Update--------------
         * UpdateRowsEventData{tableId=108, includedColumnsBeforeUpdate={0, 1, 2, 3, 4, 5}, includedColumns={0, 1, 2, 3, 4, 5}, rows=[
         *     {before=[14, AAA, sdfsdfgsd, 1, Thu Jan 01 08:00:00 CST 1970, Thu Jan 01 08:00:00 CST 1970], after=[14, AAA邹, sdfsdfgsd, 1, Thu Jan 01 08:00:00 CST 1970, Thu Jan 01 08:00:00 CST 1970]}
         * ]}
         * Delete--------------
         * DeleteRowsEventData{tableId=108, includedColumns={0, 1, 2, 3, 4, 5}, rows=[
         *     [14, AAA邹, sdfsdfgsd, 1, Thu Jan 01 08:00:00 CST 1970, Thu Jan 01 08:00:00 CST 1970]
         * ]}
         */
        client.registerEventListener(event -> {
            EventData data = event.getData();
            if (data instanceof UpdateRowsEventData) {
                System.out.println("Update--------------");
                System.out.println(data.toString());
            } else if (data instanceof WriteRowsEventData) {
                System.out.println("Write---------------");
                System.out.println(data.toString());
            } else if (data instanceof DeleteRowsEventData) {
                System.out.println("Delete--------------");
                System.out.println(data.toString());
            }
        });
        client.connect();
    }
}
