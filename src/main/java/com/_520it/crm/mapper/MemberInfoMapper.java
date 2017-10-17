package com._520it.crm.mapper;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.query.MemberInfoQueryObject;
import org.apache.ibatis.annotations.Param;
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

    //宠物服务需要的方法
    MemberInfo queryInfoByMemberId(String memberId);
    /**
     * 收银管理:根据会员号码查询 会员信息
     * @param number
     * @return
     */
    MemberInfo queryMemberByNumber(String number);

    /**
     * 根据会员id查询 余额
     * @param memberId
     * @return
     */
    double queryBalanceByMemberId(Long memberId);

    /**
     * 根据会员id 更新 会员余额
     * @param balance
     * @param memberId
     */
    void updateMemberBalanceByMember(@Param("balance") double balance,@Param("memberId") Long memberId);
}