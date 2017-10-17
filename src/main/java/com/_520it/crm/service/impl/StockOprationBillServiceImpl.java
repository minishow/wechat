package com._520it.crm.service.impl;

import com._520it.crm.domain.*;
import com._520it.crm.mapper.*;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockOprationBillQueryObject;
import com._520it.crm.service.IStockOprationBillService;
import com._520it.crm.util.ParseDate;
import com._520it.crm.util.StockBIll;
import com._520it.crm.util.StockObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Administrator on 2017/10/13.
 */
@Service
public class StockOprationBillServiceImpl implements IStockOprationBillService {
    @Autowired
    private StockOprationBillMapper stockOprationBillMapper;
    @Autowired
    private ProductStockMapper productStockMapper;
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private StockIncomeRecordMapper stockIncomeRecordMapper;
    @Autowired
    private StockOutRecordMapper stockOutRecordMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        stockOprationBillMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(StockOprationBill record) {

        stockOprationBillMapper.insert(record);


        return 0;
    }

    @Override
    public StockOprationBill selectByPrimaryKey(Long id) {
        return stockOprationBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StockOprationBill> selectAll() {
        return stockOprationBillMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StockOprationBill record) {
        stockOprationBillMapper.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public PageResult queryForList(StockOprationBillQueryObject qo) {
        List<StockOutRecord> data = stockOprationBillMapper.queryForData(qo);
        Long count = stockOprationBillMapper.queryForCount(qo);
        return new PageResult(count, data);
    }


    @Override
    public void insertBill(StockBIll stockObjects) {

        List<ProductStock> stocks = productStockMapper.selectAll();
        List<StockObject> stockLists = stockObjects.getStockObjects();
        ProductInfo pinfo = new ProductInfo();
        ProductStock productStock = new ProductStock();
        OpenStock op = new OpenStock();
        StockOprationBill sob = new StockOprationBill();
        Specific specific = new Specific();
        StockIncome incomeStock = new StockIncome();
        ProductStock stock = new ProductStock();
        ProductInfo info = new ProductInfo();
        List<Long> ids = new ArrayList<>();
        for (ProductStock stock1 : stocks) {
            if(stock1.getProductInfo()!=null){
                if(stock1.getProductInfo().getId()!=null){
                    ids.add(stock1.getProductInfo().getId());
                }
            }
        }
        for (StockObject stockList : stockLists) {
            sob.setSurvivalTime(ParseDate.parseDate(stockList.getSurvivalTime()));
            sob.setWarnDate(ParseDate.parseDate(stockList.getWarnDate()));
            sob.setProductionDate(ParseDate.parseDate(stockList.getInputTime()));
            BigDecimal bigDecimal1 = new BigDecimal(stockList.getMemberPrice().toString());
            sob.setMemberPrice(bigDecimal1);
            sob.setOperation(stockList.getOperation());
            sob.setProductionPrice(stockList.getProductionPrice());
            pinfo.setId(stockList.getProductInfoId());
            sob.setProductInfo(pinfo);
            op.setId(stockList.getOpenStockId());
            sob.setOpenStock(op);
            sob.setOpenStockNumber(stockList.getSpecificNumber());
            sob.setOpenStockPrice(stockList.getProductionPrice());


              /*  sob.getProductInfo().setId();*/
             /*   sob.setProductInfo(new ProductInfo().setId(stockList.get););*/
            sob.setInputTime(new Date());
            productStock.setSn(stockList.getProductStockSn());
            sob.setProductStock(productStock);
            sob.setSn(stockList.getProductStockSn());

            specific.setId(stockList.getSpecificId());
              /*  specific.setBeforeSpecific(stockList.get);*/
            sob.setSpecific(specific);
            incomeStock.setId(stockList.getStockIncomeId());
            sob.setStockIncome(incomeStock);
            sob.setOperation(stockList.getOperation());
            sob.setWarnNumber(stockList.getWarnNumber());
            sob.setNumber(stockList.getNumber());
            sob.setCostPrice(stockList.getCostPrice());
            for (ProductStock stockObj : stocks) {
                Long id =null;
                if(stockObj.getProductInfo()!=null){
                    id =stockObj.getProductInfo().getId();
                }
                if(stockList.getStockIncomeId()==2){
                    if (id!=null) {
                        if(id==stockList.getProductInfoId()){
                                   /*入仓库*/
                            stock=stockObj;
                            stock.setSn(sob.getSn());
                            stock.setProductInfo(sob.getProductInfo());
                            stock.setWarnNumber(sob.getWarnNumber()+stock.getWarnNumber());
                            Integer number = sob.getNumber();
                            BigDecimal bigDecimal = new BigDecimal(number);
                            BigDecimal amount = sob.getCostPrice().multiply(bigDecimal).add(stock.getAmount());
                            stock.setAmount(amount);//sssssssssssssssssssssss
                            stock.setBulkNumber(sob.getOpenStockNumber()+stock.getWarnNumber());//sssssssssssssssssssssssss
                            stock.setOutcomeDate(new Date());
                            stock.setPackageNumber(sob.getNumber()+stock.getPackageNumber());//sssssssssssssssssssssss
                            stock.setStoreNumber(number+stock.getStoreNumber());//sssssssssssssssssssssssssssss
                            productStockMapper.deleteByPrimaryKey(stock.getId());
                            productStockMapper.insert(stock);
                        }else if(!ids.contains(stockList.getProductInfoId())){
                            stock.setId(null);
                            stock=stockObj;
                            stock.setSn(sob.getSn());
                            stock.setProductInfo(sob.getProductInfo());
                            stock.setWarnNumber(sob.getWarnNumber()+stock.getWarnNumber());
                            Integer number = sob.getNumber();
                            BigDecimal bigDecimal = new BigDecimal(number);
                            BigDecimal amount = sob.getCostPrice().multiply(bigDecimal).add(stock.getAmount());
                            stock.setAmount(amount);//sssssssssssssssssssssss
                            stock.setBulkNumber(sob.getOpenStockNumber()+stock.getWarnNumber());//sssssssssssssssssssssssss
                            stock.setOutcomeDate(new Date());
                            stock.setPackageNumber(sob.getNumber()+stock.getPackageNumber());//sssssssssssssssssssssss
                            stock.setStoreNumber(number+stock.getStoreNumber());//sssssssssssssssssssssssssssss
                            productStockMapper.insert(stock);
                        }
                    }
                }else{
                    if (id!=null) {
                        if(id==stockList.getProductInfoId()){
                                   /*入仓库*/
                            stock=stockObj;
                            stock.setSn(sob.getSn());
                            stock.setProductInfo(sob.getProductInfo());
                            stock.setWarnNumber(stock.getWarnNumber()-sob.getWarnNumber());
                            Integer number = sob.getNumber();
                           if(stock.getStoreNumber()-number<0){
                             throw    new RuntimeException("库存不足,当前库存为："+stock.getStoreNumber());
                            }
                            BigDecimal bigDecimal = new BigDecimal(number);
                            BigDecimal amount = stock.getAmount().subtract(sob.getCostPrice().multiply(bigDecimal));
                            stock.setAmount(amount);//sssssssssssssssssssssss
                            stock.setBulkNumber(stock.getBulkNumber()-sob.getOpenStockNumber());//sssssssssssssssssssssssss
                            stock.setOutcomeDate(new Date());
                            stock.setPackageNumber(stock.getPackageNumber()-sob.getNumber());//sssssssssssssssssssssss
                            stock.setStoreNumber(stock.getStoreNumber()-number);//sssssssssssssssssssssssssssss
                            productStockMapper.deleteByPrimaryKey(stock.getId());
                            productStockMapper.insert(stock);
                        }else if(!ids.contains(stockList.getProductInfoId())){
                        }
                    }
                }

            }

            Long infoId = stockList.getProductInfoId();
            ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(sob.getProductInfo().getId());
       /* 入库明细*/
            sob.setProductStock(stock);
            stockOprationBillMapper.insert(sob);

            stock.setProductPart(productInfo.getProductPart());
                /*入库记录*/
   /*     Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();*/
            if (sob.getStockIncome().getId() == 2) {
              /* 入库记录*/
                Integer recordNumber = sob.getNumber();
                StockIncomeRecord income = new StockIncomeRecord();
                BigDecimal inNumber = new BigDecimal(recordNumber);
                income.setAmount(inNumber.multiply(sob.getCostPrice()));
                income.setNumber(recordNumber);
                income.setStockOprationBill(sob);
          /*  if(employee!=null){
                income.setAuditor(employee.getName());
            }*/
                stockIncomeRecordMapper.insert(income);
            } else {
               /* 出库记录*/
                StockOutRecord outRecord = new StockOutRecord();
                outRecord.setStockOprationBill(sob);
                outRecord.setDetails(sob.getSn());
                outRecord.setState(1);
          /*  if(employee!=null){
                outRecord.setAuditor(employee.getName());
            }*/
                stockOutRecordMapper.insert(outRecord);
            }
        }







    }

    @Override
    public Long queryProductIdByName(String productInfoId) {
        return stockOprationBillMapper.queryProductIdByName(productInfoId);
    }

    @Override
    public Long querySpecificIdByName(String productInfoId) {
        return stockOprationBillMapper.querySpecificIdByName(productInfoId);

    }

    @Override
    public Long queryOpenStocksIdByName(String productInfoId) {
        return stockOprationBillMapper.queryOpenStocksIdByName(productInfoId);

    }

    @Override
    public Long queryStockIncomesIdByName(String productInfoId) {
        return stockOprationBillMapper.queryStockIncomesIdByName(productInfoId);

    }
}
