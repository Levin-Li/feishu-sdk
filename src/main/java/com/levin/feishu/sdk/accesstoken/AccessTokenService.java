package com.levin.feishu.sdk.accesstoken;


import com.levin.feishu.sdk.base.FeishuApiResp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 飞书文档地址 https://open.feishu.cn/document/ukTMukTMukTM/uMTNz4yM1MjLzUzM
 * <p>
 * app_access_token: 应用 授权凭证，开放平台可据此识别调用方的应用身份，应用可以访问应用自身相关的信息，不归属到具体的企业或者用户，比如获取当前登录应用的用户身份。
 * tenant_access_token: 租户 授权凭证，使用该access token，应用将使用自己的账号执行对应的操作，比如获取一个通讯录用户的信息。
 * user_access_token: 用户 授权凭证，使用该access token，应用将代表用户执行对应的操作，比如通过API 创建一篇云文档或者一个日程。
 */
@FeignClient(value = AccessTokenService.TAG , url = "${feishu.uri:https://open.feishu.cn}", path = "/open-apis/auth/v3/")
public interface AccessTokenService {

    String TAG = "AccessToken";

    @Operation(tags = {TAG}, summary = "获取企业自建应用App Token")
    @PostMapping(path = "/app_access_token/internal")
    AccessTokenResp getInternalAppAccessToken(AccessTokenReq req);

    @Operation(tags = {TAG}, summary = "获取企业自建应用Token")
    @PostMapping(value = "/tenant_access_token/internal")
    AccessTokenResp getInternalTenantAccessToken(AccessTokenReq req);

    @PostMapping(value = "/app_access_token")
    AccessTokenResp getAppAccessToken(AccessTokenReq req);

    @PostMapping(value = "/tenant_access_token")
    AccessTokenResp getTenantAccessToken(AccessTokenReq req);

    @PostMapping(value = "/app_ticket/resend")
    FeishuApiResp resendAppTicket(AccessTokenReq req);
}
