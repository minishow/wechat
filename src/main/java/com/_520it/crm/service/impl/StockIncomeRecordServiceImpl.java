package com._520it.crm.service.impl;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.domain.StockIncomeRecord;
import com._520it.crm.mapper.StockIncomeRecordMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockIncomeRecordQueryObject;
import com._520it.crm.service.IStockIncomeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */
@Service
public class StockIncomeRecordServiceImpl implements IStockIncomeRecordService {
    /**
     *
     */
    @Autowired
    private StockIncomeRecordMapper stockIncomeRecordMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        stockIncomeRecordMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(StockIncomeRecord record) {
        stockIncomeRecordMapper.insert(record);
        return 0;
    }

    @Override
    public StockIncomeRecord selectByPrimaryKey(Long id) {
        return stockIncomeRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StockIncomeRecord> selectAll() {
        return stockIncomeRecordMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StockIncomeRecord record) {
        stockIncomeRecordMapper.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public PageResult queryForList(StockIncomeRecordQueryObject qo) {
        List<StockIncomeRecord> data=stockIncomeRecordMapper.queryForData(qo);
        Long count=stockIncomeRecordMapper.queryForCount(qo);
        return new PageResult(count,data);
    }
}
