package com._520it.crm.query;

import lombok.Setter;
import org.apache.commons.lang.StringUtils;

@Setter
public class PayQueryObject extends QueryObject{
    private String keyword;
    public String getKeyword(){
        return StringUtils.isNotBlank(keyword) ? keyword : null;
    }
}
