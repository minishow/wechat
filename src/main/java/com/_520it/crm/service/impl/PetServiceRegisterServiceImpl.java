package com._520it.crm.service.impl;

import com._520it.crm.domain.PetServiceRegister;
import com._520it.crm.mapper.PetServiceRegisterMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetServiceRegisterQueryObject;
import com._520it.crm.service.IPetServiceRegisterService;
import com._520it.crm.vo.PetServiceChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PetServiceRegisterServiceImpl implements IPetServiceRegisterService {

    @Autowired
    private PetServiceRegisterMapper petServiceRegisterMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return petServiceRegisterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PetServiceRegister record) {
        record.setState(0);
        record.setPayment(0);
        return petServiceRegisterMapper.insert(record);
    }

    @Override
    public PetServiceRegister selectByPrimaryKey(Long id) {
        return petServiceRegisterMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PetServiceRegister> selectAll() {
        return petServiceRegisterMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(PetServiceRegister record) {
        return petServiceRegisterMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryPage(PetServiceRegisterQueryObject qo) {
        Long count = petServiceRegisterMapper.queryForCount(qo);
        if(count <= 0){
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<PetServiceRegister> result =  petServiceRegisterMapper.queryForList(qo);
        return new PageResult(count, result);
    }

    @Override
    public int startService(Long id) {
        PetServiceRegister record = petServiceRegisterMapper.selectByPrimaryKey(id);
        if (record.getState() == 0) {
            return petServiceRegisterMapper.startService(1,id,new Date());
        } else if (record.getState() == 1){
            throw new RuntimeException("服务已经开始!");
        } else if (record.getState() == 2) {
            throw new RuntimeException("服务已经结束!");
        }
        throw new RuntimeException("服务状态有问题请联系管理员!");
    }

    @Override
    public int endService(Long id) {
        PetServiceRegister record = petServiceRegisterMapper.selectByPrimaryKey(id);
        if (record.getState() == 1) {
            return petServiceRegisterMapper.endService(2,id,new Date());
        } else if (record.getState() == 0){
            throw new RuntimeException("服务还未开始!");
        } else if (record.getState() == 2){
            throw new RuntimeException("服务已经结束!");
        }
        throw new RuntimeException("服务状态有问题请联系管理员!");
    }

    @Override
    public List<PetServiceChartVO> selectServiceCountByName() {
        return petServiceRegisterMapper.selectServiceCountByName();
    }

    @Override
    public List<PetServiceChartVO> selectServiceTopCountByName() {
        return petServiceRegisterMapper.selectServiceTopCountByName();
    }
}
