package org.zyw.sponsor.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zyw.common.exception.AdException;
import org.zyw.sponsor.constant.Constants;
import org.zyw.sponsor.entity.AdUser;
import org.zyw.sponsor.repository.AdUserRepository;
import org.zyw.sponsor.service.IUserService;
import org.zyw.sponsor.util.CommonUtils;
import org.zyw.sponsor.vo.CreateUserRequest;
import org.zyw.sponsor.vo.CreateUserResponse;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:01 2019/7/27
 * @Modifyed by:
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private AdUserRepository adUserRepository;

    /**
     * 添加用户
     * @param createUserRequest
     * @return
     */
    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        if (!createUserRequest.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_REEOR);
        }
        AdUser oldUser = adUserRepository.findByUserName(createUserRequest.getUserName());
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        AdUser adUser = new AdUser(createUserRequest.getUserName(), CommonUtils.md5(createUserRequest.getUserName()));
        AdUser newUser = adUserRepository.save(adUser);
        CreateUserResponse createUserResponse = new CreateUserResponse(newUser.getId(), newUser.getUserName(), newUser.getToken(), newUser.getCreateTime(), newUser.getUpdateTime());
        return createUserResponse;
    }
}
