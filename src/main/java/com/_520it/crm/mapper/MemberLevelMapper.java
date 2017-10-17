package com._520it.crm.mapper;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.MemberLevel;
import com._520it.crm.query.MemberLevelQueryObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberLevelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberLevel memberLevel);

    MemberLevel selectByPrimaryKey(Long id);

    List<MemberLevel> selectAll();

    int updateByPrimaryKey(MemberLevel memberLevel);

	Long queryForCount(MemberLevelQueryObject qo);

	List<Brand> queryForList(MemberLevelQueryObject qo);

	void changeState(Long id);
}