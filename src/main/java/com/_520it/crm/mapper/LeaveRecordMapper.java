package com._520it.crm.mapper;

import com._520it.crm.domain.LeaveRecord;
import com._520it.crm.query.LeaveRecordQueryObject;

import java.util.List;

public interface LeaveRecordMapper {

    int deleteByPrimaryKey(Long id);

    int insert(LeaveRecord record);

    LeaveRecord selectByPrimaryKey(Long id);

    List<LeaveRecord> selectAll();

    int updateByPrimaryKey(LeaveRecord record);

    Long selectByCount(LeaveRecordQueryObject qo);

    List<LeaveRecord> selectByPageList(LeaveRecordQueryObject qo);

    void saveByCancelReason(LeaveRecord leaveRecord);

}