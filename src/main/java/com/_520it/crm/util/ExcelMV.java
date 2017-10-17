package com._520it.crm.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrator on 2017/10/16.
 */
@Setter@Getter@ToString
public class ExcelMV {
    private String stockIncomeId;
    private String specificId;
    private String productInfoId;
    private String productStockSn;
    private String productionPrice;
    private String openStockId;
    private String costPrice;
    private String memberPrice;
     private String inputTime;
    private String warnDate;
    private String survivalTime;
    private  String number;
    private  String specificNumber;
    private  String warnNumber;
    private String operation;
   /* public String getStockIncomeId() {
        if(stockIncomeId==null){
            return "";
        }
        return stockIncomeId;
    }

    public String getOperation() {
        if(StringUtils.isNotBlank(operation)){
            return "";
        }
        return operation;
    }

    public String getMemberPrice() {
        if(memberPrice==null){
            return "";
        }
        return memberPrice;
    }

    public String getSpecificId() {
        if(specificId==null){
            return "";
        }
        return specificId;
    }

    public String getProductInfoId() {
        if (productInfoId==null){
            return "";
        }
        return productInfoId;
    }

    public String getProductStockSn() {
        if(StringUtils.isNotBlank(productStockSn)){
            return "";
        }
        return productStockSn;
    }

    public String getProductionPrice() {
        if(productionPrice==null){
            return  "";
        }
        return productionPrice;
    }

    public String getOpenStockId() {
        if(openStockId==null){
            return "";
        }
        return openStockId;
    }

    public String getCostPrice() {
        if(costPrice==null){
            return  "";
        }
        return costPrice;
    }

    public String getInputTime() {
        return inputTime;
    }

    public String getWarnDate() {
        if(warnDate==null){
            return "";
        }
        return warnDate;
    }

    public String getSurvivalTime() {
        if(survivalTime==null){
            return "";
        }
        return survivalTime;
    }

    public String getNumber() {
        if(number==null){
            return "";
        }
        return number;
    }

    public String getSpecificNumber() {
        if(specificNumber==null){
            return "";
        }
        return specificNumber;
    }

    public String getWarnNumber() {
        if(warnNumber==null){
            return "";
        }
        return warnNumber;
    }*/
}
