package com.levin.feishu.sdk.org.dto;

import com.levin.feishu.sdk.base.Avatar;
import com.levin.feishu.sdk.base.BaseStatus;
import com.levin.feishu.sdk.base.CustomAttr;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;
import java.util.List;


/**
 * 飞书官方参考文档： https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/contact-v3/user/get
 *
 * 名称解释：https://open.feishu.cn/document/ukTMukTMukTM/uYTM5UjL2ETO14iNxkTN/terminology
 *
 *
 */
@Data
@ToString
@Accessors(chain = true)
@FieldNameConstants
public class UserInfo implements Serializable {


//    user_id： 用户ID，在职员工在企业内的唯一标识，支持企业自定义，同一个在职用户的 user_id 对于所有的应用都保持一致。user_id 主要用于在不同应用间进行用户数据打通。需要单独申请 获取用户 userid 权限才能在接口中获取该字段数据，仅企业自建应用才能申请该权限。
//
//    特别说明： 在部分接口中“user_id”这个字段也同时表示某一种用户身份标识的含义，会根据接口中 “user_id_type”参数，表示employee_id、open_id或union_id的其中一种，开发者请根据上下文注意区分。
//
//    employee_id： 雇员ID，在一些历史版本接口中，含义同 user_id。
//
//    open_id： 用户开放加密ID标识的一种，在接口中默认提供。OpenID 用于在同一个应用中对用户进行标识，对于同一个用户，不同应用获取到的openID是不一样的。
//
//    union_id： 用户开放加密ID标识的一种，在接口中默认提供。UnionID 用于在同一个应用开发主体下对用户进行标识，对于同一个用户，同一个开发主体名下的应用，获取到的unionID是相同的，而不同主体名下应用获取到的unionID是不同的。该ID对于商店应用和自建应用都可使用。

//    在开发者开发一个应用时合理的ID选择逻辑应该如下：
//    open_id > union_id > user_id

    String union_id;
    String user_id;
    String open_id;
    String name;
    String en_name;
    String email;
    String mobile;

    boolean mobile_visible;
    int gender;
    Avatar avatar;
    BaseStatus status;
    List<String> department_ids;
    String leader_user_id;
    String city;
    String country;
    String work_station;
    long join_time;
    boolean is_tenant_manager;
    String employee_no;

    int employee_type;

    List<Order> orders;

    List<CustomAttr> custom_attrs;

    String enterprise_email;
    String job_title;

    @Data
    @ToString
    @Accessors(chain = true)
    public static class Order {
        String department_id;
        int user_order;
        int department_order;
    }

}
