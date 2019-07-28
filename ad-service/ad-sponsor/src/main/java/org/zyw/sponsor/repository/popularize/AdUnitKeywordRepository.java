package org.zyw.sponsor.repository.popularize;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zyw.sponsor.entity.popularize.AdUnitKeyword;

/**
 * @Author: zouyaowen
 * @Description: 推广单元关键词数据访问
 * @Date: 1:42 2019/7/27
 * @Modifyed by:
 */
public interface AdUnitKeywordRepository extends JpaRepository<AdUnitKeyword,Long> {

}
