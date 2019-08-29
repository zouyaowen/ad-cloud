package org.zyw.search.index.keyword;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.zyw.search.index.IndexAware;
import org.zyw.search.utils.CommonUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Author: zouyaowen
 * @Description: key是关键词，此处为倒排索引
 * @Date: 2:15 2019/8/28
 * @Modifyed by:
 */
@Slf4j
@Component
public class UnitKeywordIndex implements IndexAware<String, Set<Long>> {
    //此处为倒排索引
    private static Map<String, Set<Long>> keywordUnitMap;
    //此处为正向索引
    private static Map<Long, Set<String>> unitKeywordMap;

    static {
        keywordUnitMap = new ConcurrentHashMap<>();
        unitKeywordMap = new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {
        if (StringUtils.isEmpty(key)) {
            return Collections.emptySet();
        }
        Set<Long> result = keywordUnitMap.get(key);
        if (result == null) {
            return Collections.emptySet();
        }
        return result;
    }

    @Override
    public void add(String keyword, Set<Long> unitSet) {

        log.info("UnitKeywordIndex, before add: {}", unitKeywordMap);
        Set<Long> unitIdSet = CommonUtils.getorCreate(keyword, keywordUnitMap, ConcurrentSkipListSet::new);
        unitIdSet.addAll(unitSet);
        for (Long unitId : unitSet) {
            Set<String> keywordSet = CommonUtils.getorCreate(
                    unitId, unitKeywordMap,
                    ConcurrentSkipListSet::new
            );
            keywordSet.add(keyword);
        }

        log.info("UnitKeywordIndex, after add: {}", unitKeywordMap);
    }

    @Override
    public void update(String key, Set<Long> value) {
        //此处更新的代价比较大，value需要遍历，不支持更新，只支持删除后再添加
        log.error("keyword index can not support update");
    }

    @Override
    public void delete(String keyword, Set<Long> unitSet) {
        log.info("UnitKeywordIndex, before delete: {}", unitKeywordMap);
        Set<Long> unitIds = CommonUtils.getorCreate(
                keyword, keywordUnitMap,
                ConcurrentSkipListSet::new
        );
        unitIds.removeAll(unitSet);
        for (Long unitId : unitSet) {
            Set<String> keywordSet = CommonUtils.getorCreate(
                    unitId, unitKeywordMap,
                    ConcurrentSkipListSet::new
            );
            keywordSet.remove(keyword);
        }
        log.info("UnitKeywordIndex, after delete: {}", unitKeywordMap);
    }

    public boolean match(Long unitId, List<String> keywords) {
        if (unitKeywordMap.containsKey(unitId)
                && CollectionUtils.isNotEmpty(unitKeywordMap.get(unitId))) {
            Set<String> unitKeywords = unitKeywordMap.get(unitId);
            return CollectionUtils.isSubCollection(keywords, unitKeywords);
        }
        return false;
    }
}
