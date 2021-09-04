package com.levin.feishu.sdk.org.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class ListDepartmentReq extends OrgBasePageReq {

    @Schema(description = "父部门的ID，填上获取部门下所有子部门")
    String parent_department_id;

    @Schema(description = "是否递归获取子部门")
    boolean fetch_child;

}
