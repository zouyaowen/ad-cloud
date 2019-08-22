package org.zyw.common.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zyw.common.exception.AdException;
import org.zyw.common.vo.CommonResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 21:21 2019/7/24
 * @Modifyed by:
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest request,
                                                     AdException adException) {
        CommonResponse<String> commonResponse = new CommonResponse<>(-1, "business error");
        commonResponse.setData(adException.getMessage());
        return commonResponse;
    }
}
