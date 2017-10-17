package com._520it.crm.service.impl;

import com._520it.crm.domain.StockOutRecord;
import com._520it.crm.mapper.StockOutRecordMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockOutRecordQueryObject;
import com._520it.crm.service.IStockOutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */
@Service
public class StockOutRecordServiceImpl implements IStockOutRecordService {
    /**
     *
     */
    @Autowired
    private StockOutRecordMapper stockOutRecordMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        stockOutRecordMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(StockOutRecord record) {
        stockOutRecordMapper.insert(record);
        return 0;
    }

    @Override
    public StockOutRecord selectByPrimaryKey(Long id) {
        return stockOutRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StockOutRecord> selectAll() {
        return stockOutRecordMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StockOutRecord record) {
        stockOutRecordMapper.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public PageResult queryForList(StockOutRecordQueryObject qo) {
        List<StockOutRecord> data=stockOutRecordMapper.queryForData(qo);
        Long count=stockOutRecordMapper.queryForCount(qo);
        return new PageResult(count,data);
    }
}
