package com._520it.crm.mapper;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.query.MemberInfoQueryObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    void updateRemark(MemberInfo info);
    //充值方法
    void updateAddMoney(@Param("number") String number,@Param("infos") BigDecimal infos);

    String getMember(String number);

}