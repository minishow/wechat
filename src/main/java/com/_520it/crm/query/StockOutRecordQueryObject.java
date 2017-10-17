package com._520it.crm.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/13.
 */
@Setter@Getter
public class StockOutRecordQueryObject extends QueryObject{
    private String keyword;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GTM+8")
    private String inputTime;
    private Date buildTime=new Date();
    public String getKeyword(){
        if(StringUtils.isNotBlank(keyword)){
            return keyword;
        }
        return null;
    }
}
