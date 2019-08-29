package org.zyw.search.index.creativeunit;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.zyw.search.index.IndexAware;
import org.zyw.search.index.adunit.AdUnitObject;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:15 2019/8/28
 * @Modifyed by:
 */
@Slf4j
@Component
public class CreativeUnitIndex implements
        IndexAware<String, CreativeUnitObject> {

    /**
     * 创意与推广单元的唯一标识接是惟一的
     * <adId-unitId, CreativeUnitObject>
     */
    private static Map<String, CreativeUnitObject> objectMap;
    /**
     * 创意到推广单元
     * <adId, unitId Set>
     */
    private static Map<Long, Set<Long>> creativeUnitMap;
    /**
     * 推广单元到创意
     * <unitId, adId set>
     */
    private static Map<Long, Set<Long>> unitCreativeMap;

    static {
        objectMap = new ConcurrentHashMap<>();
        creativeUnitMap = new ConcurrentHashMap<>();
        unitCreativeMap = new ConcurrentHashMap<>();
    }

    @Override
    public CreativeUnitObject get(String key) {
        return objectMap.get(key);
    }

    @Override
    public void add(String key, CreativeUnitObject value) {
        log.info("before add: {}", objectMap);
        objectMap.put(key, value);
        Set<Long> unitSet = creativeUnitMap.get(value.getAdId());
        if (CollectionUtils.isEmpty(unitSet)) {
            unitSet = new ConcurrentSkipListSet<>();
            creativeUnitMap.put(value.getAdId(), unitSet);
        }
        unitSet.add(value.getUnitId());
        Set<Long> creativeSet = unitCreativeMap.get(value.getUnitId());
        if (CollectionUtils.isEmpty(creativeSet)) {
            creativeSet = new ConcurrentSkipListSet<>();
            unitCreativeMap.put(value.getUnitId(), creativeSet);
        }
        creativeSet.add(value.getAdId());
        log.info("after add: {}", objectMap);
    }

    @Override
    public void update(String key, CreativeUnitObject value) {
        log.error("CreativeUnitIndex not support update");
    }

    @Override
    public void delete(String key, CreativeUnitObject value) {
        log.info("before delete: {}", objectMap);
        objectMap.remove(key);
        Set<Long> unitSet = creativeUnitMap.get(value.getAdId());
        if (CollectionUtils.isNotEmpty(unitSet)) {
            unitSet.remove(value.getUnitId());
        }
        Set<Long> creativeSet = unitCreativeMap.get(value.getUnitId());
        if (CollectionUtils.isNotEmpty(creativeSet)) {
            creativeSet.remove(value.getAdId());
        }
        log.info("after delete: {}", objectMap);
    }

    public List<Long> selectAds(List<AdUnitObject> unitObjects) {
        if (CollectionUtils.isEmpty(unitObjects)) {
            return Collections.emptyList();
        }
        List<Long> result = new ArrayList<>();
        for (AdUnitObject unitObject : unitObjects) {
            Set<Long> adIds = unitCreativeMap.get(unitObject.getUnitId());
            if (CollectionUtils.isNotEmpty(adIds)) {
                result.addAll(adIds);
            }
        }
        return result;
    }
}
