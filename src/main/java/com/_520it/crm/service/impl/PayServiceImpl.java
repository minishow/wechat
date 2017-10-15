package com._520it.crm.service.impl;

import com._520it.crm.domain.Pay;
import com._520it.crm.mapper.PayMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PayQueryObject;
import com._520it.crm.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PayServiceImpl implements IPayService {

    @Autowired
    private PayMapper payMapper;

    public PageResult query(PayQueryObject qo) {
        Long count = payMapper.selectByCount(qo);
        if (count <= 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Pay> data = payMapper.selectByPageList(qo);
        return new PageResult(count, data);
    }
}
