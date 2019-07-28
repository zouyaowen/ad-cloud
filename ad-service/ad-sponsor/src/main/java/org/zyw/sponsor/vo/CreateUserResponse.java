package org.zyw.sponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 1:57 2019/7/27
 * @Modifyed by:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private Long userId;
    private String userName;
    private String token;
    private Date createTime;
    private Date updateTime;
}
