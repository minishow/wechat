package com._520it.crm.service.impl;

import com._520it.crm.domain.StockOprationBill;
import com._520it.crm.mapper.StockOprationBillMapper;
import com._520it.crm.service.IStockOprationBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */
@Service
public class StockOprationBillServiceImpl implements IStockOprationBillService {
    @Autowired
    private StockOprationBillMapper stockOprationBillMapper;
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
}
