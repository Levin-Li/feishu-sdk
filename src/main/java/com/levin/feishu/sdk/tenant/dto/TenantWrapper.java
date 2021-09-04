package com.levin.feishu.sdk.tenant.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@ToString
@Accessors(chain = true)
public class TenantWrapper implements Serializable {

    TenantInfo tenant;

}
