package com._520it.crm.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PageResult {
    private Long total;
    private List rows = new ArrayList();
}
