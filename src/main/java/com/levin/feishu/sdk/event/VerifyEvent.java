package com.levin.feishu.sdk.event;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class VerifyEvent implements Serializable {

//     放平台会向你配置的网址推送一个 application/json 格式的 POST 请求，该请求用于验证你配置的网址的合法性。

    String challenge;    //"ajls384kdjx98XX", // 应用需要原样返回的值
    String token; //"xxxxxx",              // Token的使用可参考文档“通过Token验证事件来源”
    String type;   //"url_verification"      // 表示这是一个验证请求
    String encrypt; //"ds3da3sj32421lkkld4s5ao" // 加密字符串，解密方法请看下方的安全相关内容

}
