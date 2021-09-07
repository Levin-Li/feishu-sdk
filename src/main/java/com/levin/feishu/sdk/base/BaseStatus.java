package com.levin.feishu.sdk.base;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@FieldNameConstants
public class BaseStatus implements Serializable {
    boolean is_deleted;
    boolean is_frozen;
    boolean is_resigned;
    boolean is_activated;
}
