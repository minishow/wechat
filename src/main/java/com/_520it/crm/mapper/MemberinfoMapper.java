package com._520it.crm.mapper;

import com._520it.crm.domain.MemberInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberInfo record);

    MemberInfo selectByPrimaryKey(Long id);

    List<MemberInfo> selectAll();

    int updateByPrimaryKey(MemberInfo record);
}