package com.levin.feishu.sdk.base;

import com.levin.commons.service.support.ContextHolder;
import com.levin.commons.utils.ExceptionUtils;

public abstract class AccessContext {

    public static final ContextHolder<String, Object> holder = ContextHolder.buildThreadContext(true);

    public static String tenant_access_token(String newValue) {
        return holder.put(ExceptionUtils.getInvokeMethodName(), newValue);
    }

    public static String app_access_token(String newValue) {
        return holder.put(ExceptionUtils.getInvokeMethodName(), newValue);
    }

    public static String user_access_token(String newValue) {
        return holder.put(ExceptionUtils.getInvokeMethodName(), newValue);
    }


    public static String tenant_access_token() {
        return holder.get(ExceptionUtils.getInvokeMethodName());
    }

    public static String app_access_token() {
        return holder.get(ExceptionUtils.getInvokeMethodName());
    }

    public static String user_access_token() {
        return holder.get(ExceptionUtils.getInvokeMethodName());
    }


}
