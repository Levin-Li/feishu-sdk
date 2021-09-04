package com.levin.feishu.sdk.org.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@ToString
@Accessors(chain = true)
public class DepartmentWrapper implements Serializable {

    DepartmentInfo department;

}
