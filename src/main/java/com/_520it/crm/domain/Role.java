package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class Role {
    private Long id;
    private String roleName; //角色名称
    private String sn;
    private List<Employee> employee = new ArrayList<>();

}