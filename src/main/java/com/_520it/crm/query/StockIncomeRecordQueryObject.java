package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Administrator on 2017/10/13.
 */
@Setter@Getter@ToString
public class StockIncomeRecordQueryObject extends QueryObject{
    private String keyword;
    public String getKeyword(){
        if(StringUtils.isNotBlank(keyword)){
            return keyword;
        }
        return null;
    }

}
