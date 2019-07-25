package org.zyw.sponsor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zyw.sponsor.entity.AdUser;

/**
 * @Author: zouyaowen
 * @Description: 用户数据库操作类
 * @Date: 1:50 2019/7/26
 * @Modifyed by:
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {
    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    AdUser findByUserName(String userName);
}
