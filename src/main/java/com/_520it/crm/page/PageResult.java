package com._520it.crm.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter@Getter@AllArgsConstructor@ToString
public class PageResult {
	private Long total;
	private List rows;
}
