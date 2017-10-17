package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class PetInfoQueryObject extends QueryObject {

    private Long petTypeBtn;//宠物类别
    private Long petKindBtn;//宠物品种
    private String petNameBtn;//宠物名称
    private String memberTelBtn;//手机号码
    private String memRemarkBtn;//备注

}
