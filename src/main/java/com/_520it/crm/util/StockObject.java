package com._520it.crm.util;

import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/10/16.
 */
@Setter
@ToString
public class StockObject {
    private Long stockIncomeId;
    private Long specificId;
    private Long productInfoId;
    private String productStockSn;
    private BigDecimal productionPrice;
    private Long openStockId;
    private BigDecimal costPrice;
    private BigDecimal memberPrice;
    private String inputTime;
    private String warnDate;
    private String survivalTime;
    private  Integer number;
    private  Integer specificNumber;
    private  Integer warnNumber;
    private String operation;

    public Long getStockIncomeId() {
        if(stockIncomeId==null){
            return 0L;
        }
        return stockIncomeId;
    }

    public String getOperation() {
        if(StringUtils.isNotBlank(operation)){
            return "";
        }
        return operation;
    }

    public BigDecimal getMemberPrice() {
        if(memberPrice==null){
            return new BigDecimal(0);
        }
        return memberPrice;
    }

    public Long getSpecificId() {
        if(specificId==null){
            return 0L;
        }
        return specificId;
    }

    public Long getProductInfoId() {
        if (productInfoId==null){
            return 0L;
        }
        return productInfoId;
    }

    public String getProductStockSn() {
        if(StringUtils.isNotBlank(productStockSn)){
            return "";
        }
        return productStockSn;
    }

    public BigDecimal getProductionPrice() {
        if(productionPrice==null){
            return new BigDecimal(0);
        }
        return productionPrice;
    }

    public Long getOpenStockId() {
        if(openStockId==null){
            return 0L;
        }
        return openStockId;
    }

    public BigDecimal getCostPrice() {
        if(costPrice==null){
            return new BigDecimal(0);
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

    public Integer getNumber() {
        if(number==null){
            return 0;
        }
        return number;
    }

    public Integer getSpecificNumber() {
        if(specificNumber==null){
            return 0;
        }
        return specificNumber;
    }

    public Integer getWarnNumber() {
        if(warnNumber==null){
            return 0;
        }
        return warnNumber;
    }
}

/*    str=str+"name"+i+":"+rowDates[i]['productInfo.name']+",";
    str=str+"code"+i+":"+rowDates[i]['productInfo.code']+",";
    str=str+"costPrice"+i+":"+rowDates[i]['costPrice']+",";
    str=str+"memberPrice"+i+":"+rowDates[i]['memberPrice']+",";
    str=str+"number"+i+":"+rowDates[i]['number']+",";
    str=str+"stockIncomeId"+i+":"+rowDates[i]['stockIncome.id']+",";
    str=str+"productStockSn"+i+":"+rowDates[i]['productStock.sn']+",";
    str=str+"specificNumber"+i+":"+rowDates[i]['specific.number']+",";
    str=str+"specificId"+i+":"+rowDates[i]['specific.id']+",";
    str=str+"stockSpecific"+i+":"+rowDates[i]['specific.stockSpecific']+",";
    str=str+"inputTime"+i+":"+rowDates[i]['inputTime']+",";
    str=str+"warnDate"+i+":"+rowDates[i]['warnDate']+",";
    str=str+"warnNumber"+i+":"+rowDates[i]['warnNumber']+",";*/