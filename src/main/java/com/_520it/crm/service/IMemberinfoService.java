package com._520it.crm.service;

import com._520it.crm.domain.MemberInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public interface IMemberInfoService {
    int deleteByPrimaryKey(Long id);

    int insert(MemberInfo record);

    MemberInfo selectByPrimaryKey(Long id);

    List<MemberInfo> selectAll();

    int updateByPrimaryKey(MemberInfo record);
}
