package com.levin.feishu.sdk.exception;

import feign.FeignException;
import feign.Request;

public class FeishuApiAccessException extends FeignException {

    public FeishuApiAccessException(int status, String message, Request request, Throwable cause) {
        super(status, message, request, cause);
    }

    public FeishuApiAccessException(int status, String message, Request request, Throwable cause, byte[] responseBody) {
        super(status, message, request, cause, responseBody);
    }

    public FeishuApiAccessException(int status, String message, Request request, byte[] responseBody) {
        super(status, message, request, responseBody);
    }
}
