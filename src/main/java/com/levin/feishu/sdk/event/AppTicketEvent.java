package com.levin.feishu.sdk.event;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

@Data
@Accessors(chain = true)
public class AppTicketEvent implements Serializable {

    String ts; // "1502199207.7171419", //  事件发送的时间，一般近似于事件发生的时间。
    String uuid; // "bc447199585340d1f3728d26b1c0297a",  // 事件的唯一标识
    String token; // "41a9425ea7df4536a7623e38fa321bae", // 即Verification Token
    String type; // "event_callback", // 此事件此处始终为event_callback
    Map<String, String> event; // {  "app_id" : "cli_xxx",   "app_ticket":"xxx",   "type":"app_ticket" }

}
