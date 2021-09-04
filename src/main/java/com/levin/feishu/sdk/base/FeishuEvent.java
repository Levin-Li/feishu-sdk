package com.levin.feishu.sdk.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class FeishuEvent<HEADER extends FeishuEvent.Header, T extends Serializable> implements Serializable {

    String schema;// 2.0,

    HEADER header;

    Payload<T> event;

    public static class Payload<T extends Serializable> implements Serializable {
        T object;

        //变更事件
        T old_object;
    }


    public static class Header implements Serializable {
        String event_id;      // 5e3702a84e847582be8db7fb73283c02,
        String event_type;      // vc.meeting.meeting_ended_v1,
        String create_time;      // 1608725989000,
        String token;      // rvaYgkND1GOiu5MM0E1rncYC6PLtF7JV,
        String app_id;      // cli_9f5343c580712544,
        String tenant_key;      // 2ca1d211f64f6438
    }

}
