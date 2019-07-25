package org.zyw.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.zyw.annotation.IgnoreResponseAdvice;
import org.zyw.vo.CommonResponse;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 0:22 2019/7/24
 * @Modifyed by:
 */
@RestControllerAdvice
@SuppressWarnings("unchecked")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (returnType.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        CommonResponse<Object> commonResponse = new CommonResponse<>(200, "success");
        if (null == body) {
            return commonResponse;
        }else if(body instanceof CommonResponse){
            commonResponse = (CommonResponse<Object>) body;
        }else{
            commonResponse.success(body);
        }
        return commonResponse;
    }
}
