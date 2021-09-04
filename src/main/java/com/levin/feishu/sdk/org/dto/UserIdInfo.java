package com.levin.feishu.sdk.org.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 *
 */
@Data
@ToString
@Accessors(chain = true)
public class UserIdInfo implements Serializable {
    String department_chat_acceptor_user_id; // ou_7dab8a3d3cdcc9da365777c7ad535d62,
    String external_chat_acceptor_user_id; // ou_7dab8a3d3cdcc9da365777c7ad535d62,
    String docs_acceptor_user_id; // ou_7dab8a3d3cdcc9da365777c7ad535d62,
    String calendar_acceptor_user_id; // ou_7dab8a3d3cdcc9da365777c7ad535d62,
    String application_acceptor_user_id; // ou_7dab8a3d3cdcc9da365777c7ad535d62,
    String helpdesk_acceptor_user_id; // ou_7dab8a3d3cdcc9da365777c7ad535d62

}
