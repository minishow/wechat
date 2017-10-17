package com._520it.crm.query;

/*import com.sun.xml.internal.bind.v2.model.core.ID;*/
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

@Setter
public class EmployeeQueryObject extends QueryObject{
    private String keyword;
    public String getKeyword(){
        return StringUtils.isNotBlank(keyword) ? keyword : null;
    }
}
