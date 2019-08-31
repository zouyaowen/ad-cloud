package org.zyw.search.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.zyw.search.mysql.BinlogClient;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 23:59 2019/8/31
 * @Modifyed by:
 */
@Slf4j
@Component
public class BinlogRunner implements CommandLineRunner {
    @Autowired
    private BinlogClient client;
    @Override
    public void run(String... args) throws Exception {
        log.info("Coming in BinlogRunner...");
        client.connect();
    }
}
