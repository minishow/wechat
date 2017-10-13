package com._520it.crm.mapper;

import com._520it.crm.domain.PetInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetInfo record);

    PetInfo selectByPrimaryKey(Long id);

    List<PetInfo> selectAll();

    int updateByPrimaryKey(PetInfo record);
}