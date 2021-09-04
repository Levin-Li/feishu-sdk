package com.levin.feishu.sdk.base;

public enum DepartmentIdType {

//    2021年4月起，我们更新了部门管理相关接口策略，支持复用已经删除的部门department_id。更新后，部门ID不再是全局唯一，不推荐作为应用中部门的唯一标识，建议使用 open_department_id 替代。
//    tenant_key： 企业唯一标识。企业安装应用时开放平台通过事件推送给应用，或在用户登录授权时返回。
//    department_id： 部门的自定义ID，最大长度为128，且不能以od-作为开头。
//    open_department_id： 部门开放加密ID标识，open_department_id 跨应用、跨开发主体都是相同的。
    department_id,//以自定义department_id来标识部门
    open_department_id,//以open_department_id来标识部门
}
