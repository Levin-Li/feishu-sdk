package com.levin.feishu.sdk.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;

@Data
@Accessors(chain = true)
public class FeishuApiPageReq extends FeishuApiReq {

    @Schema(description = "分页标记，第一次请求不填，表示从头开始遍历；分页查询结果还有更多项时会同时返回新的 page_token，下次遍历可采用该 page_token 获取查询结果")
    String page_token;

    @Schema(description = "分页大小,最大值：50")
    @Max(50)
    int page_size = 20;

}
