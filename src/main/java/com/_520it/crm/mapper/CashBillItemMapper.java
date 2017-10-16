package com._520it.crm.mapper;

import com._520it.crm.domain.CashBillItem;
import java.util.List;

public interface CashBillItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CashBillItem record);

    CashBillItem selectByPrimaryKey(Long id);

    List<CashBillItem> selectAll();

    int updateByPrimaryKey(CashBillItem record);
}