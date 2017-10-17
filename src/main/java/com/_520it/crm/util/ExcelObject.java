package com._520it.crm.util;

/**
 * Created by Administrator on 2017/10/16.
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Vector;

@Setter@Getter@ToString
public class ExcelObject {
    private Vector<ExcelMV> stockObjects;
}