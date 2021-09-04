package com.levin.feishu.sdk.accesstoken;

import com.levin.feishu.sdk.base.FeishuApiReq;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class AccessTokenReq extends FeishuApiReq {

    //https://open.feishu.cn/document/ukTMukTMukTM/uYTM5UjL2ETO14iNxkTN/terminology
//    app_id： 飞书开放平台应用的唯一标识。
//    app_secret： 飞书开放平台应用的秘钥。创建 APP 的时候由开放平台生成，可以用于接口调用，请务必注意保管，应用开发者可在 开发者后台 > 应用详情页面 > 凭证与基础信息 内查看 app_secret。
//    scope： 调用开放平台接口、获取数据的权限。每一个应用需要在版本中声明自己所需要的权限，并且得到安装该应用的企业管理员授权通过，才可以实际拥有某一个企业下的具体权限。缺失权限的应用，可能会出现接口调用不通、获取不到事件推送、接口/事件中缺失一些字段等问题，开发者可以自行查看开发文档，了解应用需要哪些权限。开发者可以在 开发者后台 > 应用详情页面 > 权限管理 内查看和声明应用权限。
//    app_ticket： 飞书开放平台通过 APP 的事件通知地址定时推送给 APP 后端的一个短期有效票据，是商店应用获取 app_access_token 的必要参数之一。开发者可以不关注 ticket 的有效期，用最新收到的 ticket 即可，如果调用接口发现 ticket 失效，说明新 ticket 推送没收到，可以调用接口触发再次推送。仅应用商店应用有该票据。

    String app_id;
    String app_secret;
    String app_ticket;
}
