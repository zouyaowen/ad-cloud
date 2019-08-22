package org.zyw.sponsor.util;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.util.DigestUtils;
import org.zyw.common.exception.AdException;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author: zouyaowen
 * @Description: 通用工具类
 * @Date: 2:11 2019/7/27
 * @Modifyed by:
 */
public class CommonUtils {

    private static String[] parsePatterns = {
            "yyyy-MM-dd",
            "yyyy/MM/dd",
            "yyyy.MM.dd",
    };

    /**
     * MD5转换工具
     *
     * @param value
     * @return
     */
    public static String md5(String value) {
        return DigestUtils.md5DigestAsHex(value.getBytes());
    }

    public static Date parseStringDate(String dateString) {
        try {
            return DateUtils.parseDate(dateString, parsePatterns);
        } catch (ParseException e) {
            throw new AdException(e.getMessage());
        }
    }
}
