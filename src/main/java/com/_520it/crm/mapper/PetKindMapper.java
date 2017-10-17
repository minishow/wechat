package com._520it.crm.mapper;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.PetKind;
import com._520it.crm.query.PetKindQueryObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetKindMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetKind petKind);

    PetKind selectByPrimaryKey(Long id);

    List<PetKind> selectAll();

    int updateByPrimaryKey(PetKind petKind);


    /**
     * 增加会员选择宠物
     * @param kindID //宠物类型Id
     * @return
     */
    List<PetKind> selectKindAll(Long kindID);

	Long queryForCount(PetKindQueryObject qo);

	List<Brand> queryForList(PetKindQueryObject qo);

	void changeState(Long id);

    List<PetKind> queryKindByTypeId(Long id);
}