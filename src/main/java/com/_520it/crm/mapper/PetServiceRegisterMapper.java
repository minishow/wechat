package com._520it.crm.mapper;

import com._520it.crm.domain.PetServiceRegister;
import com._520it.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetServiceRegisterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetServiceRegister record);

    PetServiceRegister selectByPrimaryKey(Long id);

    List<PetServiceRegister> selectAll();

    int updateByPrimaryKey(PetServiceRegister record);

    Long queryForCount(QueryObject qo);
    List<PetServiceRegister> queryForList(QueryObject qo);

    void startService(@Param("state") Integer state,@Param("id") Long id);

    void endService(@Param("state") Integer state,@Param("id") Long id);
}