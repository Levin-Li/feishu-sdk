package com.levin.feishu.sdk.base;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
@FieldNameConstants
public class CustomAttr implements Serializable {

    /**
     * 自定义字段类型
     * <p>
     * TEXT
     * HREF
     * ENUMERATION
     * PICTURE_ENUM
     * GENERIC_USER
     */
    String type;
    String id;//自定义字段ID
    Value value;

    @Data
    @ToString
    @Accessors(chain = true)
    @FieldNameConstants
    public static class Value implements Serializable {

        String text;//字段类型为 TEXT 时该参数定义字段值，字段类型为 HREF 时该参数定义网页标题

        String url;//字段类型为 HREF 时，该参数定义默认 URL

        String pc_url;//字段类型为 HREF 时，该参数定义PC端 URL

        String option_value;//选项值

        String name;//名称

        String picture_url;// 图片链接

        Type generic_user;
    }


    @Data
    @ToString
    @Accessors(chain = true)
    @FieldNameConstants
    public static class Type implements Serializable {
        String id;//用户的user_id
        int type;//用户类型 1：用户
    }

}
