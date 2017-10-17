package com._520it.crm.mapper;

import com._520it.crm.domain.OpenStock;
import java.util.List;

public interface OpenStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OpenStock record);

    OpenStock selectByPrimaryKey(Long id);

    List<OpenStock> selectAll();

    int updateByPrimaryKey(OpenStock record);
}