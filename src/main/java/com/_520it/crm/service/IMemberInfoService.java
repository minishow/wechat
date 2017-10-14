package com._520it.crm.service;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberInfoQueryObject;

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

    PageResult queryMemberByList(MemberInfoQueryObject qo);

    //宠物服务需要的方法
    MemberInfo queryInfoByMemberId(String memberId);
}
