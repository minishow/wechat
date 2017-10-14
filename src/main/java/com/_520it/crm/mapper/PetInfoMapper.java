package com._520it.crm.mapper;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.domain.PetInfo;
import com._520it.crm.query.PetInfoQueryObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetInfo record);

    PetInfo selectByPrimaryKey(Long id);

    List<PetInfo> selectAll();

    int updateByPrimaryKey(PetInfo record);


    long queryMemberInfoByTotal(PetInfoQueryObject qo);

    List<MemberInfo> queryMemberInfoByList(PetInfoQueryObject qo);
}