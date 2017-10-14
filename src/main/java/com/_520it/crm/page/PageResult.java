package com._520it.crm.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

<<<<<<< HEAD
@Setter@Getter@AllArgsConstructor@ToString
=======
@Setter@Getter@NoArgsConstructor@AllArgsConstructor
>>>>>>> c7ac706ce2989c4dd962dc62ec27c55dfc6c923b
public class PageResult {
	private Long total;
	private List rows;
}

