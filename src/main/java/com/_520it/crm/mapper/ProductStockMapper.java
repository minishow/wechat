package com._520it.crm.mapper;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.query.ProductStockQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductStock record);

    ProductStock selectByPrimaryKey(Long id);

    List<ProductStock> selectAll();

    int updateByPrimaryKey(ProductStock record);

    List<ProductStock> queryForData(ProductStockQueryObject qo);

    Long queryForCount(ProductStockQueryObject qo);

    ProductStock getProductStockByProductinfoCode(String code);

    /**
     * 根据商品id  查询  库存的整装数量
     * @param productinfoId
     * @return
     */
    Integer queryPackageNumberByProductInfoId(Long productinfoId);

    /**
     * 根据  商品id  更改 库存的 整装数量
     * @param packageNumber
     * @param id
     */
    void updatePackageNumberByProductinfoId(@Param("packageNumber") Integer packageNumber, @Param("productinfoId")Long productinfoId);
}