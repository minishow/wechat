package com._520it.crm.mapper;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.query.MemberInfoQueryObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberInfo record);

    MemberInfo selectByPrimaryKey(Long id);

    List<MemberInfo> selectAll();

    int updateByPrimaryKey(MemberInfo record);

    long queryMemberInfoByTotal(MemberInfoQueryObject qo);

    List<MemberInfo> queryMemberInfoByList(MemberInfoQueryObject qo);

    /**
     * 收银管理:根据会员号码查询 会员信息
     * @param number
     * @return
     */
    MemberInfo queryMemberByNumber(String number);
}