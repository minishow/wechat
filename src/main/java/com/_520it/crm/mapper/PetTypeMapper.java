package com._520it.crm.mapper;

import com._520it.crm.domain.Location;
import com._520it.crm.domain.PetType;
import com._520it.crm.query.PetTypeQueryObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetType petType);

    PetType selectByPrimaryKey(Long id);

    List<PetType> selectAll();

    int updateByPrimaryKey(PetType petType);

    List<PetType> selectKindAll(Long kindID);

	Long queryForCount(PetTypeQueryObject qo);

	List<Location> queryForList(PetTypeQueryObject qo);

	void changeState(Long id);
}