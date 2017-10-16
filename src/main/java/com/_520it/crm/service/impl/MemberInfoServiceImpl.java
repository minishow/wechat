package com._520it.crm.service.impl;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.domain.Membertop;
import com._520it.crm.domain.PetInfo;
import com._520it.crm.mapper.MemberInfoMapper;
import com._520it.crm.mapper.MembertopMapper;
import com._520it.crm.mapper.PetInfoMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberInfoQueryObject;
import com._520it.crm.service.IMemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberInfoServiceImpl implements IMemberInfoService {



    @Autowired
    private MemberInfoMapper memberInfoMapper;


    @Autowired
    private MembertopMapper membertopMapper;


    @Autowired
    private PetInfoMapper petInfoMapper;



    @Override
    public int deleteByPrimaryKey(Long id) {


        return memberInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MemberInfo record) {

        return memberInfoMapper.insert(record);
    }

    @Override
    public MemberInfo selectByPrimaryKey(Long id) {

        return memberInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MemberInfo> selectAll() {

        return memberInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(MemberInfo record) {

        return memberInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryMemberByList(MemberInfoQueryObject qo) {

        PageResult pageResult = null;
        long pagetotal=memberInfoMapper.queryMemberInfoByTotal(qo);
        if(pagetotal==0){
            return new PageResult(pagetotal,new ArrayList()) ;
        }
        List<MemberInfo> dataList = memberInfoMapper.queryMemberInfoByList(qo);


        return new PageResult(pagetotal,dataList);
    }

    @Override
    public void insertMemberAndpet(MemberInfo mem, PetInfo pet) {
        try {
            mem.setNumber(mem.getTel());
            memberInfoMapper.insert(mem);

            pet.setMember(mem);

            petInfoMapper.insert(pet);
        }catch (Exception e){


            e.printStackTrace();
        }


    }

    @Override
    public void updateRemark() {
        MemberInfo info = new MemberInfo();
        info.setRemark(1);
        memberInfoMapper.updateRemark(info);
    }

    /**
     * 充值方法
     * @param memLevel 充值记录
     * @param info 充值会员
     */
    @Override
    public void addMonberMoney(Membertop memLevel, MemberInfo info) {


        BigDecimal infos =null;
        if ( info.getBalance()==null){
           infos=memLevel.getTopbalance();
        }else {
            infos=info.getBalance().add(memLevel.getTopbalance());
        }
        memberInfoMapper.updateAddMoney(info.getNumber(),infos);
        String memberName = memberInfoMapper.getMember(info.getNumber());
        memLevel.setTopmembernumber(info.getNumber());
        memLevel.setTopmembername(memberName);
        memLevel.setTopdate(new Date());
        memLevel.setTopshopnumber("UD24316483");
        memLevel.setTopshopname("小白的店");
        //增加充值记录
        membertopMapper.insert(memLevel);


    }
}
