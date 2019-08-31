package org.zyw.search.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: zouyaowen
 * @Description: 数据库配置信息
 * @Date: 17:47 2019/8/31
 * @Modifyed by:
 */
@Component
@ConfigurationProperties(prefix = "adconf.mysql")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinlogConfig {
    private String host;
    private Integer port;
    private String username;
    private String password;

    private String binlogName;
    private Long position;
}
