package com.levin.feishu.sdk.config;

import com.levin.feishu.sdk.base.FeishuApiResp;
import com.levin.feishu.sdk.exception.FeishuApiAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FeishuApiExceptionHandler {

    @ExceptionHandler(FeishuApiAccessException.class)
    public FeishuApiResp onException(FeishuApiAccessException ex) {

        FeishuApiResp<Object> apiResp = new FeishuApiResp();

        apiResp.setHttpStatusCode(ex.status());

        apiResp.setDetailMsg(ex.contentUTF8());

        return apiResp;
    }

}
