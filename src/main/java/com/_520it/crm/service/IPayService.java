package com._520it.crm.service;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.PayQueryObject;

public interface IPayService {

    PageResult query(PayQueryObject qo);
}
