package com._520it.crm.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor

public class PageResult  {
	private Long total;
	private List rows;
}

