package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

@Setter@Getter
public class CashBillItemQueryObject extends QueryObject{
    private String productName;

    private Long billId;

    public String getProductName() {
        return StringUtils.isNotBlank(productName)?productName:null;
    }
}
