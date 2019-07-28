package org.zyw.sponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @Author: zouyaowen
 * @Description: 创建用户对象
 * @Date: 1:53 2019/7/27
 * @Modifyed by:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String userName;

    public Boolean validate() {
        return !StringUtils.isEmpty(this.userName);
    }


}
