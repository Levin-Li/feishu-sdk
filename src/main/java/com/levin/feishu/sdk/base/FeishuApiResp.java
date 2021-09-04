package com.levin.feishu.sdk.base;

import com.levin.commons.service.domain.ApiResp;
import lombok.Builder;

import javax.validation.constraints.NotNull;


public class FeishuApiResp<T> extends ApiResp<T> {


    public FeishuApiResp() {
        super();
    }

}
