package com._520it.crm.web.controller;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.service.IMemberInfoService;
import com._520it.crm.util.SendMail;
import com._520it.crm.vo.MailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mailPlatform")
public class MailPlatformController {

    @Autowired
    private IMemberInfoService memberInfoService;

    @RequestMapping("")
    public String main(){
        return "mailPlatform";
    }

    @RequestMapping("/queryMemberInfo")
    @ResponseBody
    public List<MemberInfo> queryMemberInfo(){
        List<MemberInfo> result = memberInfoService.selectAll();
        return result;
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public AjaxResult sendEmail(MailVO mailVO){
        AjaxResult result = null;
        try{
            SendMail.receiveMailAccount = mailVO.getReceiveMailAccount();
            SendMail.fromName = mailVO.getFromName();//发送人名字
            SendMail.receiveName = mailVO.getReceiveName();//接收人名字
            SendMail.mailTitle = mailVO.getMailTitle();//邮件主题
            SendMail.mailText = mailVO.getMailText();//邮件文本
            SendMail.sendMail();
            result = new AjaxResult(true,"发送邮件成功!");
        }catch(Exception e){
            e.printStackTrace();
            result = new AjaxResult(e.getMessage());
        }
        return result;
    }
}
