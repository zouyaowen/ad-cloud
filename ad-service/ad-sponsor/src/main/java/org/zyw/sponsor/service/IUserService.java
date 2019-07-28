package org.zyw.sponsor.service;

import org.zyw.sponsor.vo.CreateUserRequest;
import org.zyw.sponsor.vo.CreateUserResponse;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 1:52 2019/7/27
 * @Modifyed by:
 */
public interface IUserService {
    /**
     * 添加用户
     * @param createUserRequest
     * @return CreateUserResponse
     */
    CreateUserResponse createUser(CreateUserRequest createUserRequest);
}
