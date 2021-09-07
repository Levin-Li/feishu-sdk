package com.levin.feishu.sdk.base;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.levin.commons.service.support.ContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

@Slf4j
public class FeishuEventDispatcher {

    public static final ContextHolder<String, Class> eventTypes = ContextHolder.buildContext(true);

    private final MultiValueMap<String, Function<FeishuEvent, Boolean>> eventHandlers = new LinkedMultiValueMap<>();

    private final MultiValueMap<String, Function<JsonObject, Boolean>> eventHandlers2 = new LinkedMultiValueMap<>();

    /**
     * @param eventType
     * @param handlers
     * @return
     */
    public FeishuEventDispatcher addJsonEventHandlers(String eventType, Function<JsonObject, Boolean /* 是否已经处理了事件 */>... handlers) {
        eventHandlers2.addAll(eventType, Arrays.asList(handlers));
        return this;
    }

    public FeishuEventDispatcher addEventHandlers(String eventType, Function<FeishuEvent, Boolean /* 是否已经处理了事件 */>... handlers) {
        eventHandlers.addAll(eventType, Arrays.asList(handlers));
        return this;
    }

    public void onEvent(String json) {
        onEvent(JsonParser.parseString(json));
    }

    public void onEvent(JsonElement element) {

        String eventType = element.getAsJsonObject()
                .getAsJsonObject(FeishuEvent.Fields.header)
                .get(FeishuEvent.Header.Fields.event_type)
                .getAsString();

        Class eventClass = (Class) eventTypes.get(eventType);

        Object data = element;

        if (eventClass == null) {

            log.warn("收到事件，但没有注册响应的事件类型");

        } else {

        }

        for (Function<FeishuEvent, Boolean> handler : eventHandlers.getOrDefault(eventType, Collections.emptyList())) {

        }

    }

}
