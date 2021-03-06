package com._520it.crm.service;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.domain.Membertop;
import com._520it.crm.domain.PetInfo;
import com._520it.crm.vo.ReturnMemberVO;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberInfoQueryObject;

import java.util.List;


public interface IMemberInfoService {
    int deleteByPrimaryKey(Long id);

    int insert(MemberInfo record);

    MemberInfo selectByPrimaryKey(Long id);

    List<MemberInfo> selectAll();

    int updateByPrimaryKey(MemberInfo record);

    PageResult queryMemberByList(MemberInfoQueryObject qo);

    void insertMemberAndpet(MemberInfo mem, PetInfo pet);

    void updateRemark(Long memberID);

    void addMonberMoney(Membertop memLevel, MemberInfo info);
    //宠物服务需要的方法
    MemberInfo queryInfoByMemberId(String memberId);

    MemberInfo queryMemberByNumber(String number);

    //退卡消费查询
    List<ReturnMemberVO> returnMemberList(Long id);
}
