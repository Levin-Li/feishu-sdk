package com.levin.feishu.sdk.base;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@FieldNameConstants
public class Avatar implements Serializable {

     String avatar_origin;

     String avatar_72;
     String avatar_240;
     String avatar_640;

}
