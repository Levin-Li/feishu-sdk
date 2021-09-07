package com.levin.feishu.sdk.base;

import com.levin.commons.service.domain.ServiceReq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

@Data
@Accessors(chain = true)
@FieldNameConstants
public class FeishuApiReq implements ServiceReq {

    @Schema(description = "根据client_token是否一致来判断是否为同一请求")
    String client_token;

}
