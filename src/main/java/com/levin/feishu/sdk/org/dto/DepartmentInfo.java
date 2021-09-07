package com.levin.feishu.sdk.org.dto;

import com.levin.feishu.sdk.base.BaseStatus;
import com.levin.feishu.sdk.base.I18nName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 飞书官方参考文档：https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/department/get
 *
 */
@Data
@ToString
@Accessors(chain = true)
@FieldNameConstants
public class DepartmentInfo implements Serializable {

    //    tenant_key： 企业唯一标识。企业安装应用时开放平台通过事件推送给应用，或在用户登录授权时返回。
//    department_id： 部门的自定义ID，最大长度为128，且不能以od-作为开头。
//    open_department_id： 部门开放加密ID标识，open_department_id 跨应用、跨开发主体都是相同的。
//2021年4月起，我们更新了部门管理相关接口策略，支持复用已经删除的部门department_id。更新后，部门ID不再是全局唯一，不推荐作为应用中部门的唯一标识，建议使用 open_department_id 替代。

    String name; //  DemoName,
    I18nName i18n_name;
    String parent_department_id; //  D067,
    String department_id; //  D096,
    String open_department_id; //  od-4e6ac4d14bcd5071a37a39de902c7141,
    String leader_user_id; //  ou_7dab8a3d3cdcc9da365777c7ad535d62,
    String chat_id; //  oc_5ad11d72b830411d72b836c20,
    String order; //  100,
    List<String> unit_ids;
    int member_count;//:100,
    BaseStatus status;

}
