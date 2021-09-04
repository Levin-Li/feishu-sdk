package com.levin.feishu.sdk.org.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class ListUserReq extends OrgBasePageReq {

    @Schema(description = "部门的ID")
    String department_id;

}
