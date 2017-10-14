package com._520it.crm.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor@ToString
public class PetServiceMenu {

    private Long id;//服务编号
    private String text;//服务名称
    private Integer minPrice;//最低价格
    private Integer maxPrice;//最高价格
    private Long unit;//单位(次/天)
    private String remark;//备注
    private Integer isDiscount;//是否有折扣
    private String discount;//折扣

    private PetServiceMenu parent;
    private List<PetServiceMenu> children = new ArrayList<PetServiceMenu>();

}