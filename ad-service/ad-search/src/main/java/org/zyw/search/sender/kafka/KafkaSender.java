package org.zyw.search.sender.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.zyw.search.mysql.dto.MySqlRowData;
import org.zyw.search.sender.ISender;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 17:30 2019/8/31
 * @Modifyed by:
 */
@Component
@Slf4j
public class KafkaSender implements ISender {

    @Value("${adconf.kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    @Override
    public void sender(MySqlRowData rowData) {

    }
}
