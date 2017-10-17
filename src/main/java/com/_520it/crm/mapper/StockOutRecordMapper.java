package com._520it.crm.mapper;

import com._520it.crm.domain.StockOutRecord;
import com._520it.crm.query.StockOutRecordQueryObject;

import java.util.List;

public interface StockOutRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockOutRecord record);

    StockOutRecord selectByPrimaryKey(Long id);

    List<StockOutRecord> selectAll();

    int updateByPrimaryKey(StockOutRecord record);

    List<StockOutRecord> queryForData(StockOutRecordQueryObject qo);

    Long queryForCount(StockOutRecordQueryObject qo);
}