package com.levin.feishu.sdk.tenant;


import com.levin.feishu.sdk.base.FeishuApiResp;
import com.levin.feishu.sdk.config.FeishuFeignConfig;
import com.levin.feishu.sdk.tenant.dto.TenantWrapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 */
@FeignClient(value = TenantService.TAG, configuration = {FeishuFeignConfig.class}, url = "${feishu.uri:https://open.feishu.cn}", path = "open-apis/tenant/")
public interface TenantService {

    String TAG = "TenantService";

    @Operation(tags = {TAG}, summary = "获取信息")
    @GetMapping("/v2/tenant/query")
    FeishuApiResp<TenantWrapper> retrieve();

}
