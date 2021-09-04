package com.levin.feishu.sdk.base;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

public class PageableData<T> implements Serializable {

    @Schema(description = "是否还有更多项")
    boolean has_more;

    @Schema(description = "分页标记，当 has_more 为 true 时，会同时返回新的 page_token，否则不返回 page_token")
    String page_token;

    @Schema(description = "数据项")
    List<T> items;

}
