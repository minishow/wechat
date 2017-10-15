package com._520it.crm.service;

import com._520it.crm.domain.LeaveRecord;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.LeaveRecordQueryObject;

import java.util.List;

public interface ILeaveRecordService {
    int deleteByPrimaryKey(Long id);

    int insert(LeaveRecord record);

    LeaveRecord selectByPrimaryKey(Long id);

    List<LeaveRecord> selectAll();

    int updateByPrimaryKey(LeaveRecord record);
    /**
     * @param qo 分页
     * */
    PageResult queryByPageList(LeaveRecordQueryObject qo);

    void saveByCancelReason(LeaveRecord leaveRecord);
}
