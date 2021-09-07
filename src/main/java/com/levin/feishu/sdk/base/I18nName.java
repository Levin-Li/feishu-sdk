package com.levin.feishu.sdk.base;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@FieldNameConstants
public class I18nName implements Serializable {
    String zh_cn; //  Demo名称,
    String ja_jp; //  デモ名,
    String en_us; //  Demo Name
}
