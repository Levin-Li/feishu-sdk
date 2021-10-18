package com.levin.feishu.sdk.config;

import com.google.gson.Gson;
import com.levin.commons.service.support.ContextHolder;
import com.levin.feishu.sdk.base.AccessContext;
import com.levin.feishu.sdk.base.FeishuApiResp;
import com.levin.feishu.sdk.exception.FeishuApiAccessException;
import feign.FeignException;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.ErrorDecoder;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class FeishuFeignConfig {

//    @Bean
//    public Contract feignContract() {
//        return new feign.Contract.Default();
//    }


//    @Bean
//    public Request.Options options() {
//        return new Request.Options(5000, 10000);
//    }

    @Value("${feishu.authHeadName:Authorization}")
    String authHeadName = "Authorization";


    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder.Default() {
            @Override
            public Exception decode(String methodKey, Response response) {

                byte[] buf = null;

                try {
                    buf = IOUtils.toByteArray(response.body().asInputStream());
                } catch (Exception e) {
                    log.debug("read body error", e);
                }

//               Class type = response.request().requestTemplate().feignTarget().type();

                FeishuApiAccessException ex = new FeishuApiAccessException(response.status(), response.status() + " - " + response.reason(), response.request(), buf);

                return ex;
            }
        };
    }

    @Bean
    public RequestInterceptor authRequestInterceptor() {
        return (RequestTemplate requestTemplate) -> {
            if (!requestTemplate.headers().containsKey(authHeadName)) {
                requestTemplate.header(authHeadName, "Bearer " + AccessContext.tenant_access_token());
            }
        };
    }

    @Bean
    public FallbackFactory fallbackFactory() {
        return new FBFactory();
    }

    public static class FBFactory implements FallbackFactory {

        static final ContextHolder<String, Object> fallbacks = ContextHolder.buildContext(true);

        static final ThreadLocal<FeignException> throwableThreadLocal = new ThreadLocal<>();

        @Override
        public Object create(Throwable ex) {

            if (ex instanceof FeignException) {
                FeignException feignEx = (FeignException) ex;

                throwableThreadLocal.set(feignEx);

                Class type = feignEx.request().requestTemplate().feignTarget().type();

                return fallbacks.getAndAutoPut(type.getName(), null, () -> {
                    return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{type}, (Object proxy, Method method, Object[] args) ->
                    {
                        FeignException currentEx = throwableThreadLocal.get();

                        String json = currentEx.contentUTF8();

                        FeishuApiResp apiResp;

                        if (StringUtils.hasText(json)) {
                            apiResp = new Gson().fromJson(json, FeishuApiResp.class);
                        } else {
                            apiResp = (FeishuApiResp) new FeishuApiResp()
                                    .setCode(-1)
                                    .setMsg(currentEx.toString());
                        }

                        apiResp.setHttpStatusCode(currentEx.status());

                        return apiResp;

                    });
                });
            } else if (ex instanceof RuntimeException) {
                throw (RuntimeException) ex;
            } else {
                throw new RuntimeException(ex);
            }
        }

    }

}
