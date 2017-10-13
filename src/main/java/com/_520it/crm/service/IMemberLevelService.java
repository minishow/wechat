package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.MemberLevel;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberLevelQueryObject;

public interface IMemberLevelService {
    int deleteByPrimaryKey(Long id);

    int insert(MemberLevel memberLevel);

    MemberLevel selectByPrimaryKey(Long id);

    List<MemberLevel> selectAll();

    int updateByPrimaryKey(MemberLevel memberLevel);

	PageResult query(MemberLevelQueryObject qo);

	void changeState(Long id);
}
