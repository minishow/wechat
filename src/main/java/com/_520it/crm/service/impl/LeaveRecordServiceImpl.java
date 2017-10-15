package com._520it.crm.service.impl;

import com._520it.crm.domain.LeaveRecord;
import com._520it.crm.mapper.LeaveRecordMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.LeaveRecordQueryObject;
import com._520it.crm.service.ILeaveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LeaveRecordServiceImpl implements ILeaveRecordService {

    @Autowired
    private LeaveRecordMapper leaveRecordMapper;

    public int deleteByPrimaryKey(Long id) {
        return leaveRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LeaveRecord record) {
        record.setState(LeaveRecord.GENDER_LEAVE);
        return leaveRecordMapper.insert(record);
    }

    @Override
    public LeaveRecord selectByPrimaryKey(Long id) {
        return leaveRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<LeaveRecord> selectAll() {
        return leaveRecordMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(LeaveRecord record) {
        return leaveRecordMapper.updateByPrimaryKey(record);
    }
    //分页数据操作
    public PageResult queryByPageList(LeaveRecordQueryObject qo) {
        Long count = leaveRecordMapper.selectByCount(qo);
        if(count <= 0){
            return new PageResult(0L,Collections.EMPTY_LIST);
        }
        List<LeaveRecord> data = leaveRecordMapper.selectByPageList(qo);
        return new PageResult(count,data);
    }


    public void saveByCancelReason(LeaveRecord leaveRecord) {
        leaveRecordMapper.saveByCancelReason(leaveRecord);
    }

}
