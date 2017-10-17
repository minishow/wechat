package com._520it.crm.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class CashBillQueryObject extends QueryObject {
    private String keyword; // 会员卡号
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8") //后台传到前台
    @DateTimeFormat(pattern="yyyy-MM-dd") //前台传到后台
    private Date beginDate; // 开始收银时间

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8") //后台传到前台
    @DateTimeFormat(pattern="yyyy-MM-dd") //前台传到后台
    private Date endDate;  //结束 收银时间
    private Integer way = -1; //收款方式:

    private Long billId;

    public String getKeyword() {
        return StringUtils.isNotBlank(keyword) ? keyword : null;
    }
}
