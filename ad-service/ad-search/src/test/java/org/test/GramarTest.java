package org.test;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:49 2019/8/23
 * @Modifyed by:
 */
public class GramarTest {
    @Test
    public void test1() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(new Integer(5),"54321");
        map.put(new Integer(4),"54321");
        map.put(new Integer(3),"54321");
        map.put(new Integer(2),"54321");
        map.put(new Integer(1),"54321");
        System.out.println(map);
    }

}
