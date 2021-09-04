package com.levin.feishu.sdk.org;


import com.levin.feishu.sdk.base.FeishuApiResp;
import com.levin.feishu.sdk.base.PageableData;
import com.levin.feishu.sdk.config.FeishuFeignConfig;
import com.levin.feishu.sdk.org.dto.DepartmentInfo;
import com.levin.feishu.sdk.org.dto.DepartmentWrapper;
import com.levin.feishu.sdk.org.dto.ListDepartmentReq;
import com.levin.feishu.sdk.org.dto.OrgBaseReq;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 飞书文档地址 https://open.feishu.cn/document/ukTMukTMukTM/uMTNz4yM1MjLzUzM
 */
@FeignClient(value = DepartmentService.TAG, configuration = {FeishuFeignConfig.class}, url = "${feishu.uri:https://open.feishu.cn}", path = "/open-apis/contact/v3/departments")
public interface DepartmentService {

    String TAG = "DepartmentService";

    @Operation(tags = {TAG}, summary = "创建部门")
    @PostMapping
    FeishuApiResp<DepartmentWrapper> create(@SpringQueryMap OrgBaseReq req, @RequestBody DepartmentInfo departmentInfo);


    @Operation(tags = {TAG}, summary = "获取部门信息")
    @GetMapping("/{department_id}")
    FeishuApiResp<DepartmentWrapper> retrieve(@PathVariable String department_id, @SpringQueryMap OrgBaseReq req);


    @Operation(tags = {TAG}, summary = "修改部门部分信息")
    @PatchMapping("/{department_id}")
    FeishuApiResp<DepartmentWrapper> patch(@PathVariable String department_id, @SpringQueryMap OrgBaseReq req, @RequestBody DepartmentInfo departmentInfo);

    @Operation(tags = {TAG}, summary = "修改部门全部信息")
    @PutMapping("/{department_id}")
    FeishuApiResp<DepartmentWrapper> update(@PathVariable String department_id, @SpringQueryMap OrgBaseReq req, @RequestBody DepartmentInfo departmentInfo);

    @Operation(tags = {TAG}, summary = "删除部门")
    @DeleteMapping("/{department_id}")
    FeishuApiResp delete(@PathVariable String department_id, @SpringQueryMap OrgBaseReq req);


    @Operation(tags = {TAG}, summary = "获取部门列表")
    @GetMapping
    FeishuApiResp<PageableData<DepartmentInfo>> list(@SpringQueryMap ListDepartmentReq req);


    @Operation(tags = {TAG}, summary = "获取多级父部门列表", description = "该接口用来递归获取部门父部门的信息，并按照由子到父的顺序返回有权限的父部门信息列表。")
    @GetMapping("/parent")
    FeishuApiResp<PageableData<DepartmentInfo>> getParents(@SpringQueryMap ListDepartmentReq req);


    @Operation(tags = {TAG}, summary = "搜索部门")
    @PostMapping("/search")
    FeishuApiResp<PageableData<DepartmentInfo>> search(@SpringQueryMap ListDepartmentReq req, @RequestBody String query);


}
