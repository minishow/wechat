package com._520it.crm.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MailVO {
    private String fromName;//发送人名字
    private String receiveName;//接收人名字
    private String mailTitle;//邮件主题
    private String mailText;//邮件文本
    // 收件人邮箱
    private String receiveMailAccount;
}
