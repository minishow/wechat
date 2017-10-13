package com._520it.crm.util;

import lombok.*;

/**
 * Created by Administrator on 2017/10/13.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AjaxObject {
    private boolean success=true;
    private String msg;
}
