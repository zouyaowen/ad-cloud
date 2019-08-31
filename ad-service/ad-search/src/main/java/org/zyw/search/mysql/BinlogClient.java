package org.zyw.search.mysql;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.zyw.search.mysql.listener.AggregationListener;

import java.io.IOException;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 17:47 2019/8/31
 * @Modifyed by:
 */
@Slf4j
@Component
public class BinlogClient {
    private BinaryLogClient client;

    @Autowired
    private BinlogConfig config;
    @Autowired
    private AggregationListener listener;

    public void connect() {
        new Thread(() -> {
            client = new BinaryLogClient(
                    config.getHost(),
                    config.getPort(),
                    config.getUsername(),
                    config.getPassword()
            );
            if (!StringUtils.isEmpty(config.getBinlogName()) &&
                    !config.getPosition().equals(-1L)) {
                client.setBinlogFilename(config.getBinlogName());
                client.setBinlogPosition(config.getPosition());
            }
            client.registerEventListener(listener);
            try {
                log.info("connecting to mysql start");
                client.connect();
                log.info("connecting to mysql done");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    public void close() {
        try {
            client.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
