package com.levin.feishu.sdk.accesstoken;

import com.levin.feishu.sdk.SdkTestConfiguration;
import com.levin.feishu.sdk.base.AccessContext;
import com.levin.feishu.sdk.base.FeishuApiResp;
import com.levin.feishu.sdk.base.PageableData;
import com.levin.feishu.sdk.org.DepartmentService;
import com.levin.feishu.sdk.org.UserService;
import com.levin.feishu.sdk.org.dto.DepartmentInfo;
import com.levin.feishu.sdk.org.dto.ListDepartmentReq;
import com.levin.feishu.sdk.org.dto.ListUserReq;
import com.levin.feishu.sdk.org.dto.UserInfo;
import com.levin.feishu.sdk.tenant.TenantService;
import com.levin.feishu.sdk.tenant.dto.TenantWrapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
@SpringBootTest(classes = {SdkTestConfiguration.class})
class AccessTokenServiceTest {

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;


    @Autowired
    TenantService tenantService;

    @Value("${feishu.appId}")
    String appId;

    @Value("${feishu.appSecret}")
    String appSecret;


    AccessTokenResp tokenResp;

    @BeforeEach
    void init(){

        tokenResp = accessTokenService.getInternalAppAccessToken(new AccessTokenReq()
                .setApp_id(appId).setApp_secret(appSecret));

        Assertions.assertEquals(0, tokenResp.getCode());

    }

    @Test
    void getInternalAppAccessToken() {


        //设置 token
        AccessContext.tenant_access_token(tokenResp.getTenant_access_token());


        FeishuApiResp<PageableData<UserInfo>> apiResp = userService.list(new ListUserReq());

        FeishuApiResp<PageableData<DepartmentInfo>> list = departmentService.list(new ListDepartmentReq().setFetch_child(true));

        System.out.println(list);

    }

    @Test
    void tenantService() {

        AccessContext.tenant_access_token(tokenResp.getTenant_access_token());

        FeishuApiResp<TenantWrapper> retrieve = tenantService.retrieve();

        System.out.println(retrieve);
    }
}