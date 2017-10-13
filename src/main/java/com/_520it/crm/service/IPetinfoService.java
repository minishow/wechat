package com._520it.crm.service;

import com._520it.crm.domain.PetInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public interface IPetInfoService {

    int deleteByPrimaryKey(Long id);

    int insert(PetInfo record);

    PetInfo selectByPrimaryKey(Long id);

    List<PetInfo> selectAll();

    int updateByPrimaryKey(PetInfo record);


}
