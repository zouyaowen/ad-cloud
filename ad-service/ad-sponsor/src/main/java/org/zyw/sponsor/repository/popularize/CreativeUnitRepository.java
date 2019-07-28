package org.zyw.sponsor.repository.popularize;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zyw.sponsor.entity.popularize.CreativeUnit;

/**
 * @Author: zouyaowen
 * @Description: 创意与推广单元的关联数据库操作
 * @Date: 1:49 2019/7/27
 * @Modifyed by:
 */
public interface CreativeUnitRepository extends JpaRepository<CreativeUnit,Long> {
}
