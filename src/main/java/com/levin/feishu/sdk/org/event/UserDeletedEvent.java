package com.levin.feishu.sdk.org.event;

import com.levin.feishu.sdk.base.FeishuEvent;
import com.levin.feishu.sdk.org.dto.UserInfo;

/**
 *
 * <p>
 * "old_object": {
 * "department_ids": [
 * "员工所属的部门ID"
 * ],
 * "open_id": "ou_xxxxxxxxxx"
 * }
 */
public class UserDeletedEvent extends FeishuEvent<FeishuEvent.Header, UserInfo> {


}
