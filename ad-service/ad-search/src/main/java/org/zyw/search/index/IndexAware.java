package org.zyw.search.index;

/**
 * @Author: zouyaowen
 * @Description: 索引接口
 * @Date: 2:15 2019/8/23
 * @Modifyed by:
 */
public interface IndexAware<K, V> {

    /**
     * 获取
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 添加索引
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 更新索引
     * @param key
     * @param value
     */
    void update(K key, V value);

    /**
     * 删除索引
     * @param key
     * @param value
     */
    void delete(K key, V value);
}
