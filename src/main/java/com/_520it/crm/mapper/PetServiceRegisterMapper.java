package com._520it.crm.mapper;

import com._520it.crm.domain.PetServiceRegister;
import com._520it.crm.query.QueryObject;
import com._520it.crm.vo.PetServiceChartVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PetServiceRegisterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetServiceRegister record);

    PetServiceRegister selectByPrimaryKey(Long id);

    List<PetServiceRegister> selectAll();

    int updateByPrimaryKey(PetServiceRegister record);

    Long queryForCount(QueryObject qo);
    List<PetServiceRegister> queryForList(QueryObject qo);

    int startService(@Param("state") Integer state, @Param("id") Long id, @Param("startTime")Date date);

    int endService(@Param("state") Integer state,@Param("id") Long id, @Param("endTime")Date date);

    List<PetServiceChartVO> selectServiceCountByName();

    List<PetServiceChartVO> selectServiceTopCountByName();

    void updatePayfor(Long id);

    List<PetServiceRegister> selectPayEnd();
}