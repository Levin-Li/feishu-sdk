package com.levin.feishu.sdk.tenant.dto;

import com.levin.feishu.sdk.base.Avatar;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
@FieldNameConstants
public class TenantInfo implements Serializable {
    String name; // 企业名称,
    String display_id; // F123456789,
    int tenant_tag; // 0,
    String tenant_key; // abcdefghi,
    Avatar avatar;
}
