package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PetServiceRegisterQueryObject extends QueryObject {

    private String keyword_petName;
    private String keyword_tel;
}
