package com.levin.feishu.sdk.accesstoken;

import com.levin.feishu.sdk.base.FeishuApiResp;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
public class AccessTokenResp extends FeishuApiResp {

    @Schema(description = "应用 授权凭证，开放平台可据此识别调用方的应用身份，应用可以访问应用自身相关的信息，不归属到具体的企业或者用户，比如获取当前登录应用的用户身份。")
    String app_access_token;

    @Schema(description = "租户 授权凭证，使用该access token，应用将使用自己的账号执行对应的操作，比如获取一个通讯录用户的信息。")
    String tenant_access_token;

    @Schema(description = "用户 授权凭证，使用该access token，应用将代表用户执行对应的操作，比如通过API 创建一篇云文档或者一个日程。")
    String user_access_token;

    @Schema(description = "token 过期时间，单位：秒")
    Long expire;

}
