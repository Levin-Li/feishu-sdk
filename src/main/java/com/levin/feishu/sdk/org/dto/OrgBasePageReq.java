package com.levin.feishu.sdk.org.dto;

import com.levin.feishu.sdk.base.DepartmentIdType;
import com.levin.feishu.sdk.base.FeishuApiPageReq;
import com.levin.feishu.sdk.base.UserIdType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

@Data
@ToString
@Accessors(chain = true)
@FieldNameConstants
public class OrgBasePageReq extends FeishuApiPageReq {

    @Schema(description = "可选值：open_id，union_id，user_id；默认值：open_id")
    UserIdType user_id_type;

    @Schema(description = "此次调用中使用的部门ID的类型，可选值：department_id，open_department_id；默认值：open_department_id")
    DepartmentIdType department_id_type;

}
