package com.A31.shop.naverapi.dept;

import java.util.ArrayList;


import lombok.Getter;


@Getter
public class DeptListDTO {
	
	ArrayList<Element> elements = new ArrayList();;
	private int totalCount;
}
