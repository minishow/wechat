package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Administrator on 2017/10/13.
 */
@Setter@Getter@ToString
public class ProductStockQueryObject extends QueryObject {
    private  String  keyword;
    private  String  productName;
    private  String  productType;
    private Integer page=1;
    private Integer rows=10;
    public String getKeyword(){
        if(StringUtils.isNotBlank(keyword)){
            return keyword;
        }
        return null;
    }

    public String getProductType(){
        if(StringUtils.isNotBlank(productType)){
            return productType;
        }
        return null;
    }

    public String getProductName(){
        if(StringUtils.isNotBlank(productName)){
            return productName;
        }
        return null;
    }
    public Integer getPageStart(){
        return (this.page-1)*this.rows;
    }
}
