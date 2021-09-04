package com.levin.feishu.sdk.org;


import com.levin.feishu.sdk.base.FeishuApiResp;
import com.levin.feishu.sdk.base.PageableData;
import com.levin.feishu.sdk.config.FeishuFeignConfig;
import com.levin.feishu.sdk.org.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 飞书文档地址https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/user/overview
 */
@FeignClient(value = UserService.TAG, configuration = {FeishuFeignConfig.class}, url = "${feishu.uri:https://open.feishu.cn}", path = "/open-apis/contact/v3/users")
public interface UserService {

    String TAG = "UserService";

    @Operation(tags = {TAG}, summary = "创建用户")
    @PostMapping
    FeishuApiResp<UserWrapper> create(@SpringQueryMap OrgBaseReq req, @RequestBody UserInfo userInfo);

    @Operation(tags = {TAG}, summary = "获取用户信息")
    @GetMapping("/{user_id}")
    FeishuApiResp<UserWrapper> retrieve(@PathVariable String user_id, @SpringQueryMap OrgBaseReq req);

    @Operation(tags = {TAG}, summary = "修改用户部分信息")
    @PatchMapping("/{user_id}")
    FeishuApiResp<UserWrapper> patch(@PathVariable String user_id, @SpringQueryMap OrgBaseReq req, @RequestBody UserInfo userInfo);

    @Operation(tags = {TAG}, summary = "修改用户全部信息")
    @PutMapping("/{user_id}")
    FeishuApiResp<UserWrapper> update(@PathVariable String user_id, @SpringQueryMap OrgBaseReq req, @RequestBody UserInfo userInfo);

    @Operation(tags = {TAG}, summary = "删除用户")
    @DeleteMapping("/{user_id}")
    FeishuApiResp delete(@PathVariable String user_id, @SpringQueryMap OrgBaseReq req, @RequestBody UserIdInfo userIdInfo);

    @Operation(tags = {TAG}, summary = "获取制定部门的用户列表")
    @GetMapping
    FeishuApiResp<PageableData<UserInfo>> list(@SpringQueryMap ListUserReq req);

}
