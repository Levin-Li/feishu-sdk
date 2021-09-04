package com.levin.feishu.sdk.config;

import com.levin.feishu.sdk.base.AccessContext;
import com.levin.feishu.sdk.exception.FeishuApiAccessException;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

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

                FeishuApiAccessException ex = new FeishuApiAccessException(response.status(), response.status() + " - " + response.reason(), response.request(), buf);

                String errInfo = ex.contentUTF8();

                return ex;
            }
        };
    }

    @Bean
    public RequestInterceptor authRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {

                if (!requestTemplate.headers().containsKey(authHeadName)) {
                    requestTemplate.header(authHeadName, "Bearer " + AccessContext.tenant_access_token());
                }

            }
        };
    }

}
